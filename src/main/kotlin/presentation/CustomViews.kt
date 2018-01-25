package presentation

import data.Learning
import data.Project
import data.Skill
import kotlinx.html.FlowContent
import kotlinx.html.a
import model.SkillBase

fun FlowContent.skillBaseView(s: SkillBase) {
    +skillPretamble(s)
    a(s.linkTo) { +s.visibleName }
    s.description?.let { +it }
}

fun skillPretamble(s: SkillBase): String = when {
    s is Project -> "Project: "
    s is Learning && s.type == Learning.Type.Book -> "Book "
    s is Learning && s.type == Learning.Type.Course -> "Course "
    else -> ""
}

fun FlowContent.connectedSkillsView(connectedSkills: List<Skill>) {
    +"Connectes skills: "
    connectedSkills.forEachIndexed { index, s ->
        if (index != 0) {
            +", "
        }
        a(s.linkTo) { +s.visibleName }
    }
}