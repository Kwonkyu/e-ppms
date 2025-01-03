package partners.pms.module.persistence.rdb

import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import partners.pms.application.domain.account.Account
import partners.pms.core.port.outbound.account.FindAccountPort
import partners.pms.module.persistence.rdb.factory.AccountFactory
import partners.pms.module.persistence.rdb.repository.AccountRepository

@Component
@Transactional
class AccountPersistenceAdapter(
    private val accountRepository: AccountRepository,
) : FindAccountPort {
    override fun findAccountDetail(accountId: String): Account? =
        accountRepository.findByUsername(accountId)?.let { AccountFactory.ToDomain.fromEntity(it) }
}
