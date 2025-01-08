package partners.pms.application.domain.account

import enum.AccountRole
import enum.AccountStatus
import java.time.ZonedDateTime

class Account(
    val username: String,
    var password: String,
    var name: String,
    var email: String,
    var phone: String,
    var status: AccountStatus,
    var validFrom: ZonedDateTime,
    var validUntil: ZonedDateTime,
    val roles: MutableSet<AccountRole>,
) {
    val isExpired: Boolean
        get() = ZonedDateTime.now().isAfter(validUntil) || ZonedDateTime.now().isBefore(validFrom)
}
