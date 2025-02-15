package partners.pms.application.domain.category

open class CommonCategory<T>(
    var id: Long? = null,
    var code: String,
    var name: String,
    var description: String = "",
    var parent: T?,
    val children: MutableSet<T>? = null,
    var level: Int,
    var active: Boolean,
    var sort: Int,
)
