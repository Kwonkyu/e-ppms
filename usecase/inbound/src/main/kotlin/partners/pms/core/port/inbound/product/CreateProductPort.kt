package partners.pms.core.port.inbound.product

import partners.pms.core.port.inbound.product.model.request.ProductCreateRequest
import partners.pms.core.port.inbound.product.model.response.CreatedProduct

interface CreateProductPort {
    /**
     * 신규상품 생성.
     * @param request 상품생성요청 데이터
     * @return 생성된 상품 ID
     */
    fun createProduct(request: ProductCreateRequest): CreatedProduct
}
