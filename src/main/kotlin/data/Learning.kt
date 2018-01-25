package data

import model.SkillBase
import data.Learning.Type.Book
import data.Learning.Type.Course

enum class Learning(
        override val visibleName: String,
        val type: Type,
        val comment: String? = null,
        override val description: String? = null
) : SkillBase {
    CleanCode("Clean Code", Type.Book),
    KotlinInAction("Kotlin in Action", Type.Book),
    EffectiveJava("Effective Java", Book, comment = "Not yet finished"),
    MachineLearningCoursera("Machine Learning on Coursera", Course, description = "Course was about basics of neural networks and learning algorithms.", comment = "Coursera course"),
    FunctionalProgrammingCoursera("Machine Learning on Coursera", Course),
    ;

    override val linkTo: String? by lazy { "/learning#$id" }

    enum class Type {
        Book, Course
    }

    val id: String
        get() = name

    val connectedSkills: List<Skill> by lazy { Skill.values().filter { this in it.base } }

    companion object {
        val courses = values().filter { it.type == Course }
        val books = values().filter { it.type == Book }
    }
}