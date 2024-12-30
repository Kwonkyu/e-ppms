package partners.pms.domain.product

/**
 * Root of 'product' domain.
 */
class Product(
    val id: Long,
    val code: String,
    var name: String,
    var price: Double,
)
