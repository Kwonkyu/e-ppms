package partners.pms.application.domain.category

class ProductCategory(
    id: Long? = null,
    code: String,
    name: String,
    description: String = "",
    active: Boolean = false,
    override var parent: ProductCategory? = null,
    var children: MutableSet<ProductCategory>? = null,
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
