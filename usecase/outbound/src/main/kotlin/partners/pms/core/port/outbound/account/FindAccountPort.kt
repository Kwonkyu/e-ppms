package partners.pms.core.port.outbound.account

import partners.pms.application.domain.account.Account

interface FindAccountPort {
    fun findAccountDetail(accountId: String): Account?
}
