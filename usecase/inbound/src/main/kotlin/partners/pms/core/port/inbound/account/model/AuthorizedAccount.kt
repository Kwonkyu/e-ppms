package partners.pms.core.port.inbound.account.model

import enum.AccountRole

data class AuthorizedAccount(
    val username: String,
    val password: String,
    val name: String,
    val type: String,
    val status: String,
    val roles: Set<AccountRole>,
    val email: String,
    val isExpired: Boolean,
)
