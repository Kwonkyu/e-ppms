package partners.pms.module.persistence.rdb.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import partners.pms.module.persistence.rdb.entity.Seller

@Repository
interface SellerRepository : JpaRepository<Seller, Long> {
    fun findByName(name: String): Seller?
}
