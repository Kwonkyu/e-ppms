package partners.pms.module.persistence.rdb.repository.impl

import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository
import partners.pms.module.persistence.rdb.entity.Product
import partners.pms.module.persistence.rdb.entity.QProduct.product
import partners.pms.module.persistence.rdb.repository.ProductQueryDslRepository

@Repository
class ProductQueryDslRepositoryImpl(
    private val queryFactory: JPAQueryFactory,
) : ProductQueryDslRepository {
    override fun findProductBy(
        id: Long?,
        code: String?,
        name: String?,
    ): Product? =
        queryFactory
            .selectFrom(product)
            .where(
                id?.let { product.id.eq(it) },
                code?.let { product.code.eq(it) },
                name?.let { product.name.eq(it) },
            ).fetchFirst()
}
