package partners.pms.application.service.account

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import partners.pms.core.port.inbound.account.model.request.AccountCreateRequest
import partners.pms.core.port.inbound.account.CreateAccountPort as CreateAccountEndpointPort
import partners.pms.core.port.outbound.account.CreateAccountPort as CreateAccountPersistencePort

@Service
@Transactional
class AccountMutationService(
    private val createAccountPort: CreateAccountPersistencePort,
) : CreateAccountEndpointPort {
    override fun createAccount(request: AccountCreateRequest): String =
        createAccountPort
            .createAccount(
                AccountFactory.Inbound.fromCreateRequest(request),
            ).username
}
