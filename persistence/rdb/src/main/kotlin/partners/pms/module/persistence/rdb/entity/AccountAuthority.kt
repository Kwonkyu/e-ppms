@file:Suppress("ktlint:standard:no-wildcard-imports")

package partners.pms.module.persistence.rdb.entity

import enum.AccountRole
import jakarta.persistence.*

@Entity
class AccountAuthority(
    @EmbeddedId
    val id: AccountAuthorityPK,
)

@Embeddable
class AccountAuthorityPK(
    @ManyToOne
    @JoinColumn(referencedColumnName = "username", name = "account_id")
    val account: Account,
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    val role: AccountRole,
)
