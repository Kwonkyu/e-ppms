package partners.pms.core.port.inbound.account.model

data class AuthorizedAccount(
    val username: String,
    val password: String,
    val name: String,
    val type: String,
    val status: String,
    val role: String,
    val email: String,
    val isExpired: Boolean,
)
