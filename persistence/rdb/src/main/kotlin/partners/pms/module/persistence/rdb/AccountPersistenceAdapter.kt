package partners.pms.module.persistence.rdb

import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import partners.pms.application.domain.account.Account
import partners.pms.core.port.outbound.account.CreateAccountPort
import partners.pms.core.port.outbound.account.FindAccountPort
import partners.pms.module.persistence.rdb.factory.AccountFactory
import partners.pms.module.persistence.rdb.repository.AccountRepository

@Component
@Transactional
class AccountPersistenceAdapter(
    private val accountRepository: AccountRepository,
) : FindAccountPort,
    CreateAccountPort {
    override fun findAccountDetail(accountId: String): Account? =
        accountRepository.findByUsername(accountId)?.let { AccountFactory.ToDomain.fromEntity(it) }

    override fun createAccount(request: Account): Account {
        val accountEntity = AccountFactory.ToEntity.fromDomain(request)
        return AccountFactory.ToDomain.fromEntity(accountRepository.save(accountEntity))
    }
}
