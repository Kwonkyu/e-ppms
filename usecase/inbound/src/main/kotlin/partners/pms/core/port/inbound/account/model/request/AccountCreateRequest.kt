package partners.pms.core.port.inbound.account.model.request

data class AccountCreateRequest(
    val username: String,
    val password: String,
    val name: String,
    val email: String,
    val phone: String,
)
