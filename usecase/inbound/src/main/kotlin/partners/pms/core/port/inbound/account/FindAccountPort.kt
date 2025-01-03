package partners.pms.core.port.inbound.account

import partners.pms.core.port.inbound.account.model.AuthorizedAccount

interface FindAccountPort {
    fun isAccountExists(accountId: String): Boolean

    fun findAccountDetail(accountId: String): AuthorizedAccount?
}
