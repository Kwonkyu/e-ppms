package partners.pms.module.persistence.rdb.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import partners.pms.module.persistence.rdb.entity.Product

@Repository
interface ProductRepository : JpaRepository<Product, Long> {
    fun findByCode(code: String): Product?
}
