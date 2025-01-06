package partners.pms.application.service.account

import partners.pms.application.domain.account.Account
import partners.pms.core.port.inbound.account.model.AuthorizedAccount

class AccountFactory {
    object Outbound {
        fun toAuthorizedAccount(account: Account): AuthorizedAccount =
            AuthorizedAccount(
                username = account.username,
                password = account.password,
                name = account.name,
                type = account.type,
                status = account.status,
                roles = account.roles,
                email = account.email,
                isExpired = account.isExpired,
            )
    }
}
