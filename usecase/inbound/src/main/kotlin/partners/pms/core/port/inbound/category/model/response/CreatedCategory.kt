package partners.pms.core.port.inbound.category.model.response

data class CreatedCategory(
    val code: String,
    val name: String,
    val description: String,
    val parentCode: String?,
    val active: Boolean,
)
