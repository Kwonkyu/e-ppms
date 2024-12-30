package partners.pms.module.persistence.rdb

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import partners.pms.application.domain.product.Product
import partners.pms.core.port.outbound.product.CreateProductPort
import partners.pms.core.port.outbound.product.FindProductPort
import partners.pms.core.port.outbound.product.UpdateProductPort
import partners.pms.module.persistence.rdb.factory.ProductFactory
import partners.pms.module.persistence.rdb.repository.ProductRepository

@Component
@Transactional
class ProductPersistenceAdapter(
    private val productRepository: ProductRepository,
) : CreateProductPort,
    UpdateProductPort,
    FindProductPort {
    override fun create(product: Product): Product {
        val duplicated = productRepository.existsByCode(product.code)
        if (duplicated) {
            throw IllegalStateException("Product code should be unique.")
        }

        val savedEntity = ProductFactory.ToEntity.fromDomain(product).let { productRepository.save(it) }
        return product.apply { id = savedEntity.id }
    }

    override fun update(product: Product): Product {
        val productEntity =
            productRepository.findByIdOrNull(product.id)
                ?: throw NoSuchElementException("Product not found")

        with(product) {
            productEntity.code = code
            productEntity.name = name
            productEntity.price = price
        }

        return product.apply {
            // last modified date renew??
        }
    }

    override fun findProductBy(
        id: Long?,
        code: String?,
        name: String?,
    ): Product? {
        if (id == null && code == null && name == null) {
            return null
        }
        return productRepository.findProductBy(id, code, name)?.let { ProductFactory.ToDomain.fromEntity(it) }
    }
}
