package partners.pms.module.web.http.security

import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import partners.pms.core.port.inbound.account.FindAccountPort
import partners.pms.module.web.http.model.security.AccountDetails

class LoadAccountService(
    private val findAccountPort: FindAccountPort,
) : UserDetailsService {
    override fun loadUserByUsername(username: String?): UserDetails {
        if (username == null) throw UsernameNotFoundException("Username is null")
        return findAccountPort
            .findAccountDetail(username)
            ?.let {
                AccountDetails(
                    username = it.username,
                    password = it.password,
                    name = it.name,
                    email = it.email,
                    phone = it.phone,
                    status = it.status,
                    isExpired = it.isExpired,
                    authorities = it.roles.mapTo(mutableSetOf()) { role -> SimpleGrantedAuthority("ROLE_$role") },
                )
                // 절대로 null 을 반환하지 않도록 인터페이스에 정의되어 있음
            } ?: throw UsernameNotFoundException("Username is null")
    }
}
