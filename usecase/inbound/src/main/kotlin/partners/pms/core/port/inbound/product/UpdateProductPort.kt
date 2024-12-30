package partners.pms.core.port.inbound.product

import partners.pms.core.port.inbound.product.model.request.ProductUpdateRequest

interface UpdateProductPort {
    fun updateProduct(
        productCode: String,
        request: ProductUpdateRequest,
    )
}
