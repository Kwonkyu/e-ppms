package partners.pms.application.service.product

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import partners.pms.core.port.inbound.product.model.response.SearchedProduct
import partners.pms.core.port.inbound.product.FindProductPort as FindProductEndpointPort
import partners.pms.core.port.outbound.product.FindProductPort as FindProductPersistencePort

@Service
@Transactional
class ProductQueryService(
    private val findProductPort: FindProductPersistencePort,
) : FindProductEndpointPort {
    override fun findByCode(code: String): SearchedProduct? =
        findProductPort.findProductBy(code = code)?.let {
            ProductFactory.Inbound.toSearchedProduct(it)
        }
}
