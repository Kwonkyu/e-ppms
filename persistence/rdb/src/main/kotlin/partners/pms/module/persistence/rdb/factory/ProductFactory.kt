package partners.pms.module.persistence.rdb.factory

import partners.pms.application.domain.product.Product
import partners.pms.module.persistence.rdb.entity.Product as ProductEntity

class ProductFactory {
    object ToEntity {
        fun fromDomain(product: Product): ProductEntity =
            ProductEntity(
                id = 0L,
                code = product.code,
                name = product.name,
                price = product.price,
            )
    }

    object ToDomain {
        fun fromEntity(productEntity: ProductEntity): Product =
            Product(
                id = productEntity.id,
                code = productEntity.code,
                name = productEntity.name,
                price = productEntity.price,
            )
    }
}
