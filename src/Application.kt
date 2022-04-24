package com.ezike.tobenna.graphql

import com.apurebase.kgraphql.GraphQL
import io.ktor.application.*
import io.ktor.server.netty.EngineMain

fun main(args: Array<String>): Unit = EngineMain.main(args)

fun Application.module(testing: Boolean = false) {
    install(GraphQL) {
        playground = true
        schema {
            schemaValue()
        }
    }
}
