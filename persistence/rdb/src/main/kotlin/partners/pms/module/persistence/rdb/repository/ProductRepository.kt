package partners.pms.module.persistence.rdb.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import partners.pms.module.persistence.rdb.entity.Product

@Repository
interface ProductRepository :
    JpaRepository<Product, Long>,
    ProductQueryDslRepository {
    fun existsByCode(code: String): Boolean
}

interface ProductQueryDslRepository {
    fun findProductBy(
        id: Long?,
        code: String?,
        name: String?,
    ): Product?
}
