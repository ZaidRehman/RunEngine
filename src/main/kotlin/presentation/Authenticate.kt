package presentation

import io.ktor.routing.Route
import io.ktor.application.call
import io.ktor.http.ContentType
import io.ktor.request.receiveParameters
import io.ktor.response.respondText
import io.ktor.routing.post
import model.User


fun Route.authenticateRoute() {

    post("/authenticate") {

        val post = call.receiveParameters()
        val username = post["username"]
        val password = post["password"]

        //createMongoClient()
        //val client = getMongoClient()
        //var database = client.getDatabase("coderdeer") //normal java driver usage

        //val pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
        //        fromProviders(PojoCodecProvider.builder().automatic(true).build()))
        //database = database.withCodecRegistry(pojoCodecRegistry)



        val loginUser = User(username?: "",password?: "")
        //val collection = database.getCollection("user")

        var dbPwd : String? = null
        //val dbUser = collection.find(eq("username",loginUser.username))
        //        .projection(fields(include("password"), excludeId())).forEach({ dbPwd = it.getString("password")})

        //val pwd = BCrypt.checkpw(loginUser.password,dbPwd?: BCrypt.gensalt())
        call.respondText("", ContentType.Application.Json)

    }

    post("/register") {

        val post = call.receiveParameters()
        val username = post["username"]
        val password = post["password"]

        //createMongoClient()
        //val client = getMongoClient()
        //val database = client.getDatabase("coderdeer") //normal java driver usage
        val loginUser = User(username?: "",password?: "")
        //val collection = database.getCollection<User>()
        //al pwd = BCrypt.hashpw(loginUser.password,BCrypt.gensalt())



        call.respondText("", ContentType.Application.Json)
    }
}
