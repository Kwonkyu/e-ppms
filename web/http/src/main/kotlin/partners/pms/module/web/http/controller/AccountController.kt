package partners.pms.module.web.http.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import partners.pms.core.port.inbound.account.CreateAccountPort
import partners.pms.core.port.inbound.account.model.request.AccountCreateRequest
import partners.pms.module.web.http.model.account.AccountCreateHttpRequest
import java.net.URI

@RestController
@RequestMapping("/account")
class AccountController(
    private val createAccountPort: CreateAccountPort,
) {
    @PostMapping("/new")
    fun createNewAccount(
        @RequestBody request: AccountCreateHttpRequest,
    ): ResponseEntity<String> {
        createAccountPort.createAccount(
            AccountCreateRequest(
                username = request.username,
                password = request.password,
                name = request.name,
                email = request.email,
                phone = request.phone,
            ),
        )
        return ResponseEntity.created(URI.create("/account/${request.username}")).build()
    }
}
