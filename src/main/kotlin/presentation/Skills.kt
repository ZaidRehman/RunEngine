package presentation

import data.Skill
import data.SkillCategory
import data.skillsRoot
import kotlinx.html.*
import io.ktor.routing.Route

fun Route.skillsRoute() {
    toHtmlResponseOnTemplate("/skills") {
        h2 { +"Skills:" }
        for (s in skillsRoot) {
            skillCategoryView(s)
        }
    }
}

private fun FlowContent.skillCategoryView(skillCategory: SkillCategory) {
    section(classes = "category") {
        id = skillCategory.id
        h3 { +skillCategory.visibleName }
        skillCategory.description?.let { +it }
        if (skillCategory.skills.isNotEmpty()) {
            ul {
                skillCategory.skills.forEach { s -> li { skillView(s) } }
            }
        }
    }
}

private fun FlowContent.skillView(skill: Skill) {
    section {
        id = skill.id
        h3 { +skill.visibleName }
        +skill.description
        if (skill.base.isNotEmpty()) {
            +"Skill base:"
            ul {
                skill.base.forEach { s -> li { skillBaseView(s) } }
            }
        }
    }
}