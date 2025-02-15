package partners.pms.application.domain.category

class DisplayCategory(
    id: Long? = null,
    code: String,
    name: String,
    description: String = "",
    parent: DisplayCategory? = null,
    children: MutableSet<DisplayCategory>? = null,
    level: Int,
    active: Boolean = false,
    sort: Int,
    var mappedProducts: MutableSet<MappedProduct>? = null,
) : CommonCategory<DisplayCategory>(
        id = id,
        code = code,
        name = name,
        description = description,
        parent = parent,
        level = level,
        active = active,
        sort = sort,
    )
