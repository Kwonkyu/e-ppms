package partners.pms.application.domain.account

import java.time.ZonedDateTime

class Account(
    val username: String,
    val password: String,
    val name: String,
    val type: String,
    val status: String,
    val role: String,
    val email: String,
    val validFrom: ZonedDateTime,
    val validUntil: ZonedDateTime,
) {
    val isExpired: Boolean
        get() = ZonedDateTime.now().isAfter(validUntil) || ZonedDateTime.now().isBefore(validFrom)
}
