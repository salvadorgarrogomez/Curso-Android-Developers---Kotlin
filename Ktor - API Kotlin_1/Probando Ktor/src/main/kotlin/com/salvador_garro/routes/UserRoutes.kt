package com.salvador_garro.routes

import com.salvador_garro.models.User
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

private val user = mutableListOf(
    User(1,"Salvador Garro",31, "salavaxggz@gmail.com"),
    User(2,"Salvador Gómez",31,"salavaxggz@hotmail.com"),
)

fun Route.userRouting() {
    route("/user") {
        get {
            if (user.isNotEmpty()){
                call.respond(user)
            } else {
                call.respondText("No user found", status = HttpStatusCode.NotFound)
            }
        }
        get("{id?}"){
            val id = call.parameters["id"] ?: return@get call.respondText(
                "Id not found",
                status = HttpStatusCode.BadRequest
            )
            val user = user.find { it.id == id.toInt() } ?: return@get call.respondText(
                "Usuario con $id no encontrado",
                status = HttpStatusCode.NotFound
            )
            call.respond(user)
        }
        post {
            val users = call.receive<User>()
            user.add(users)
            call.respondText("Usuario creado correctamente",
                status = HttpStatusCode.Created)
        }
        delete("{id?}"){
            val id = call.parameters["id"] ?: return@delete call.respondText(
                "Id not found",
                status = HttpStatusCode.BadRequest
            )
            if (user.removeIf() { it.id == id.toInt() }){
                call.respondText("Usuario eliminado correctamente",
                    status = HttpStatusCode.Accepted)
            } else {
                call.respondText("Usuario $id no encontrado",
                    status = HttpStatusCode.NotFound)
            }
        }
    }
}