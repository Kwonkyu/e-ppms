package partners.pms.core.port.inbound.account.model

import enum.AccountRole
import enum.AccountStatus

data class AuthorizedAccount(
    val username: String,
    val password: String,
    val name: String,
    val email: String,
    val phone: String,
    val status: AccountStatus,
    val isExpired: Boolean,
    val roles: Set<AccountRole>,
)
