package partners.pms.application.domain.category

class DisplayCategory(
    id: Long? = null,
    code: String,
    name: String,
    description: String = "",
    active: Boolean = false,
    override var parent: DisplayCategory? = null,
    var children: MutableSet<DisplayCategory>? = null,
    sort: Int = 0,
    var mappedProducts: MutableSet<MappedProduct>? = null,
) : CommonCategory(
        id = id,
        code = code,
        name = name,
        description = description,
        active = active,
        sort = sort,
    )
