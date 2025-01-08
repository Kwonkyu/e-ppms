package partners.pms.core.port.inbound.account

import partners.pms.core.port.inbound.account.model.request.AccountCreateRequest

interface CreateAccountPort {
    /**
     * 새로운 계정을 생성합니다.
     * @param request 계정 생성 요청
     * @return 생성된 계정의 ID
     */
    fun createAccount(request: AccountCreateRequest): String
}
