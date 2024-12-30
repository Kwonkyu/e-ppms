package partners.pms.core.port.outbound.product

import partners.pms.application.domain.product.Product

interface UpdateProductPort {
    fun update(product: Product): Product
}
