package partners.pms.core.port.outbound

import partners.pms.domain.product.Product

interface CreateProductPort {
    fun create(product: Product): Product
}
