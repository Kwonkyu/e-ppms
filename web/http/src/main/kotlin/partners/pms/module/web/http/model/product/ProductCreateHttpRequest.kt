package partners.pms.module.web.http.model.product

data class ProductCreateHttpRequest(
    val name: String,
    val price: Double,
    val description: String,
)
