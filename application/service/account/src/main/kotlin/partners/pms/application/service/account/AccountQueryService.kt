package partners.pms.application.service.account

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import partners.pms.core.port.inbound.account.model.AuthorizedAccount
import partners.pms.core.port.inbound.account.FindAccountPort as FindAccountEndpointPort
import partners.pms.core.port.outbound.account.FindAccountPort as FindAccountPersistencePort

@Service
@Transactional(readOnly = true)
class AccountQueryService(
    private val findAccountPort: FindAccountPersistencePort,
) : FindAccountEndpointPort {
    override fun isAccountExists(accountId: String): Boolean = findAccountPort.findAccountDetail(accountId) != null

    override fun findAccountDetail(accountId: String): AuthorizedAccount? =
        findAccountPort.findAccountDetail(accountId)?.let {
            AccountFactory.Outbound.toAuthorizedAccount(it)
        }
}
