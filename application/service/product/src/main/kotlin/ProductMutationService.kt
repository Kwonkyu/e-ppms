package partners.pms.application.product

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import partners.pms.core.port.inbound.product.CreateProductPort
import partners.pms.core.port.inbound.product.FindProductPort
import partners.pms.core.port.inbound.product.model.request.ProductCreateRequest
import partners.pms.core.port.inbound.product.model.response.CreatedProduct
import partners.pms.core.port.inbound.product.model.response.SearchedProduct

@Service
@Transactional
class ProductMutationService :
    FindProductPort,
    CreateProductPort {
    override fun findByCode(code: String): SearchedProduct? {
        TODO("Not yet implemented")
    }

    override fun createProduct(request: ProductCreateRequest): CreatedProduct {
        TODO("Not yet implemented")
    }
}
