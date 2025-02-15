package partners.pms.core.port.inbound.category.model.request

import partners.pms.common.partners.pms.common.enum.CategoryType

data class CategoryCreateRequest(
    val code: String,
    val name: String,
    val description: String,
    val parentCode: String?,
    val type: CategoryType,
    val active: Boolean,
    val sort: Int,
)
