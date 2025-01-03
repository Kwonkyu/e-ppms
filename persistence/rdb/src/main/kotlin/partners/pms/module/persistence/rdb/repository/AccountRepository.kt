package partners.pms.module.persistence.rdb.repository

import org.springframework.data.jpa.repository.JpaRepository
import partners.pms.module.persistence.rdb.entity.Account

interface AccountRepository :
    JpaRepository<Account, Long>,
    AccountQueryDslRepository {
    fun findByUsername(username: String): Account?
}

interface AccountQueryDslRepository
