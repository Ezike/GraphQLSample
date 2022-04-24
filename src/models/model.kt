package com.ezike.tobenna.graphql.models

enum class Position {
    GK,
    DEF,
    MID,
    FRW
}

// 2
data class Player(var uid: String, var name: String, var team: String, var position: Position)

// 3
data class PlayerInput(val name: String, val team: String, val position: Position)