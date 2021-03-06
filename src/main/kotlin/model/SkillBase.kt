package model

interface SkillBase: Connector {
    override val visibleName: String
    override val linkTo: String?
    val description: String?
}