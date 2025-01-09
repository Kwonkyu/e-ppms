package partners.pms.application.domain.account

import partners.pms.common.partners.pms.common.enum.AccountRole
import partners.pms.common.partners.pms.common.enum.AccountStatus
import java.time.ZonedDateTime

class Account(
    val username: String,
    var password: String,
    var name: String,
    var email: String,
    var phone: String,
    var status: AccountStatus = AccountStatus.LOCKED,
    var validFrom: ZonedDateTime,
    var validUntil: ZonedDateTime,
    val roles: MutableSet<AccountRole> = mutableSetOf(),
) {
    val isExpired: Boolean
        get() = ZonedDateTime.now().isAfter(validUntil) || ZonedDateTime.now().isBefore(validFrom)
}
