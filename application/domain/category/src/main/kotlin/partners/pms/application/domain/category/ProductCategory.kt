package partners.pms.application.domain.category

class ProductCategory(
    id: Long? = null,
    code: String,
    name: String,
    description: String = "",
    parent: ProductCategory? = null,
    children: MutableSet<ProductCategory>? = null,
    level: Int,
    active: Boolean = false,
    sort: Int = 0,
    var mappedProducts: MutableSet<MappedProduct>? = null,
) : CommonCategory<ProductCategory>(
        id = id,
        code = code,
        name = name,
        description = description,
        parent = parent,
        level = level,
        active = active,
        sort = sort,
    )
