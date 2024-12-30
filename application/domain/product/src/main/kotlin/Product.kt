package partners.pms.application.domain.product

/**
 * Root of 'product' domain.
 */
class Product(
    // var? val?
    var id: Long,
    val code: String,
    var name: String,
    var price: Double,
)
