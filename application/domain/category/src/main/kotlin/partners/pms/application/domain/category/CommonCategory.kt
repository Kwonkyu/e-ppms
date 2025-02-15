package partners.pms.application.domain.category

abstract class CommonCategory(
    var id: Long?,
    var code: String,
    var name: String,
    var description: String,
    var active: Boolean,
    var sort: Int,
) {
    abstract val parent: CommonCategory?
    val level: Int
        get() = parent?.level?.plus(1) ?: 1
}
