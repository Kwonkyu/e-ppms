package partners.pms.core.port.outbound.product

import partners.pms.application.domain.product.Product

interface CreateProductPort {
    fun create(product: Product): Product
}
