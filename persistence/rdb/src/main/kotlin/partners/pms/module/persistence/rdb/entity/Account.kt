@file:Suppress("ktlint:standard:no-wildcard-imports")

package partners.pms.module.persistence.rdb.entity

import enum.AccountStatus
import jakarta.persistence.*
import java.time.ZonedDateTime

@Entity
class Account(
    @Id
    @Column(name = "username")
    var username: String,
    @Column(name = "password")
    var password: String,
    @Column(name = "name")
    var name: String,
    @Column(name = "email")
    var email: String,
    @Column(name = "phone")
    var phone: String,
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    var status: AccountStatus,
    @Column(name = "valid_from")
    var validFrom: ZonedDateTime,
    @Column(name = "valid_until")
    var validUntil: ZonedDateTime,
    @OneToMany(mappedBy = "id.account", orphanRemoval = true, fetch = FetchType.LAZY)
    var authorities: MutableSet<AccountAuthority>,
) : Auditable()
