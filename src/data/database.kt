package com.ezike.tobenna.graphql.data

import com.ezike.tobenna.graphql.models.Player
import com.ezike.tobenna.graphql.models.Position

val players = mutableListOf(
    Player("abc123", "Sergio Ramos", "Real Madrid", Position.DEF),
    Player("abc124", "Lionel Messi", "Barcelona", Position.FRW),
    Player("abc125", "Cristiano Ronaldo", "Juventus", Position.FRW),
    Player("abc126", "Leon Goretzka", "Bayern Munich", Position.MID),
    Player("abc127", "Manuel Neuer", "Bayern Munich", Position.GK),
    Player("abc128", "Neymar Jr", "PSG", Position.FRW),
    Player("abc129", "Casemiro", "Real Madrid", Position.MID)
)