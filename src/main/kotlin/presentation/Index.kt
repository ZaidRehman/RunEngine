package presentation

import connections.createMongoClient
import data.Publishing
import data.languages
import data.projetsOnMain
import data.skillsVisible
import model.Achievement
import io.ktor.application.call
import io.ktor.freemarker.FreeMarkerContent
import io.ktor.response.respond
import io.ktor.routing.Route
import io.ktor.routing.get

fun Route.indexRoute() {
    get("/") {
        createMongoClient()
        val career = listOf(
                Achievement("docplanner", "fa-stethoscope"),
                Achievement("apreel", "fa-car"),
                Achievement("samsung", "fa-mobile"),
                Achievement("college", "fa-book")
        )
        val sections = listOf(
                Section("about-me", "nav.about_me", "About", "about.ftl", ""),
                Section("career", "nav.career", "Career", "career.ftl", "timeline"),
                Section("skills", "nav.skills", "Skills", "skills.ftl", "team"),
                Section("speaking", "nav.speaking", "Speaking", "speaking.ftl", "timeline"),
                Section("projects", "nav.projects", "Projects", "projects.ftl", "project"),
                Section("consulting", "nav.consulting", "Contact", "consulting.ftl", "testimonials navy-section")
        )
        val model = mapOf(
                "title" to "Coder Deer",
                "languages" to languages,
                "sections" to sections,
                "careers" to career,
                "skills" to skillsVisible,
                "projects" to projetsOnMain,
                "speaking" to Publishing.all
        )
        call.respond(FreeMarkerContent("login.ftl", model, "Index"))
    }
}

class Section(
        val name: String,
        val titleT: String,
        val title: String,
        val tpl: String,
        val css: String
)