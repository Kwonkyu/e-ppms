package partners.pms.application.service.product

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import partners.pms.core.port.inbound.product.model.request.ProductCreateRequest
import partners.pms.core.port.inbound.product.model.request.ProductUpdateRequest
import partners.pms.core.port.inbound.product.model.response.CreatedProduct
import java.util.NoSuchElementException
import partners.pms.core.port.inbound.product.CreateProductPort as CreateProductEndpointPort
import partners.pms.core.port.inbound.product.UpdateProductPort as UpdateProductEndpointPort
import partners.pms.core.port.outbound.product.CreateProductPort as CreateProductPersistencePort
import partners.pms.core.port.outbound.product.FindProductPort as FindProductPersistencePort
import partners.pms.core.port.outbound.product.UpdateProductPort as UpdateProductPersistencePort

@Service
@Transactional
class ProductMutationService(
    private val findProductPort: FindProductPersistencePort,
    private val createProductPort: CreateProductPersistencePort,
    private val updateProductPort: UpdateProductPersistencePort,
) : CreateProductEndpointPort,
    UpdateProductEndpointPort {
    override fun createProduct(request: ProductCreateRequest): CreatedProduct {
        val createdProduct = ProductFactory.Inbound.fromCreateRequest(request)
        return createProductPort.create(createdProduct).let { ProductFactory.Inbound.toCreatedProduct(it) }
    }

    override fun updateProduct(
        productCode: String,
        request: ProductUpdateRequest,
    ) {
        val product = findProductPort.findProductBy(code = productCode) ?: throw NoSuchElementException("Product not found")
        with(request) {
            name?.let { product.name = it }
            price?.let { product.price = it }
        }
        updateProductPort.update(product)
    }
}
