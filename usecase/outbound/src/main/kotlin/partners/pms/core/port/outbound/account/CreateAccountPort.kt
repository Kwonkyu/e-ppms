package partners.pms.core.port.outbound.account

import partners.pms.application.domain.account.Account

interface CreateAccountPort {
    fun createAccount(request: Account): Account
}
