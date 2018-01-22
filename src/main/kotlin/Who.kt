import com.google.gson.Gson
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.CallLogging
import io.ktor.features.DefaultHeaders
import io.ktor.http.ContentType
import io.ktor.response.respondText
import io.ktor.routing.Routing
import io.ktor.routing.get

fun Application.main() {
    install(DefaultHeaders)
    install(CallLogging)
    install(Routing) {
        get("/") {
            val doktor = Who("Doktor", "Gallifrey")
            val gson = Gson()
            val json = gson.toJson(doktor)
            call.respondText(json, ContentType.Application.Json)
        }
    }


}

data class Who(val name: String, val planet: String)