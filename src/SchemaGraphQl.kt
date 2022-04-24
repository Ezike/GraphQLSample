package com.ezike.tobenna.graphql

import IPlayerRepository
import PlayerRepository
import com.apurebase.kgraphql.schema.dsl.SchemaBuilder
import com.ezike.tobenna.graphql.models.Player
import com.ezike.tobenna.graphql.models.PlayerInput
import com.ezike.tobenna.graphql.models.Position
import java.util.UUID

fun SchemaBuilder.schemaValue() {
    val repository: IPlayerRepository = PlayerRepository()

    inputType<PlayerInput> {
        description = "The input of the player without id"
    }

    type<Player> {
        description = "Player object with the attributes name, team, position and identifier"
    }

    enum<Position>()

    queries(repository)

    mutations(repository)
}

private fun SchemaBuilder.mutations(repository: IPlayerRepository) {
    mutation("createPlayer") {
        description = "Create a new player"
        resolver { playerInput: PlayerInput ->
            try {
                // 4
                val uid = UUID.randomUUID().toString()
                val player = Player(uid, playerInput.name, playerInput.team, playerInput.position)
                repository.createPlayer(player)
                true
            } catch (e: Exception) {
                false
            }
        }
    }
}

private fun SchemaBuilder.queries(repository: IPlayerRepository) {
    query("playersByPosition") {
        description = "Retrieve all players by position"
        resolver { position: Position ->
            try {
                repository.filterPlayersByPosition(position)
            } catch (e: Exception) {
                emptyList()
            }
        }
    }

    query("players") {
        description = "Retrieve all players"
        resolver { ->
            try {
                repository.listPlayers()
            } catch (e: Exception) {
                emptyList<Player>()
            }
        }
    }

    query("playersByTeam") {
        description = "Retrieve all the players by his team"
        resolver { team: String ->
            try {
                repository.filterPlayersByTeam(team)
            } catch (e: Exception) {
                emptyList<Player>()
            }
        }
    }
}