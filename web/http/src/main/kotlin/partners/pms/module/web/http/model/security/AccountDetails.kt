package partners.pms.module.web.http.model.security

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import partners.pms.common.partners.pms.common.enum.AccountStatus

class AccountDetails(
    private val username: String,
    private val password: String,
    val name: String,
    val email: String,
    val phone: String,
    val status: AccountStatus,
    val isExpired: Boolean,
    val authorities: MutableSet<out GrantedAuthority>,
) : UserDetails {
    override fun getAuthorities(): MutableCollection<out GrantedAuthority> = authorities

    override fun getPassword(): String = password

    override fun getUsername(): String = username
}
