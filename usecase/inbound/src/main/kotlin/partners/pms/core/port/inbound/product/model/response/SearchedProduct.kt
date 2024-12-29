package partners.pms.core.port.inbound.product.model.response

data class SearchedProduct(
    val id: Long,
    val code: String,
    val name: String,
    val price: Double,
)
