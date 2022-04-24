import com.ezike.tobenna.graphql.data.players
import com.ezike.tobenna.graphql.models.Player
import com.ezike.tobenna.graphql.models.PlayerInput
import com.ezike.tobenna.graphql.models.Position

interface IPlayerRepository {
    fun createPlayer(player: Player)
    fun deletePlayer(uid: String)
    fun listPlayers(): List<Player>
    fun filterPlayersByPosition(position: Position): List<Player>
    fun filterPlayersByTeam(team: String): List<Player>
    fun updatePlayer(uid: String, playerInput: PlayerInput)
}

class PlayerRepository : IPlayerRepository {
    override fun createPlayer(player: Player) {
        players.add(player)
    }

    override fun deletePlayer(uid: String) {
        players.removeIf { it.uid == uid }
    }

    override fun listPlayers(): List<Player> {
        return players
    }

    override fun filterPlayersByPosition(position: Position): List<Player> {
        return players.filter { it.position == position }
    }

    override fun filterPlayersByTeam(team: String): List<Player> {
        return players.filter { it.team == team }
    }

    override fun updatePlayer(uid: String, playerInput: PlayerInput) {
        players.find { it.uid == uid }?.apply {
            name = playerInput.name
            position = playerInput.position
            team = playerInput.team
        }
    }
}