package partners.pms.common.partners.pms.common.enum

enum class AccountStatus {
    /** 정상 활성상태 */
    ACTIVE,

    /** 장기 미접속 휴면상태 */
    DORMANT,

    /**계정 초기생성 또는 로그인 실패로 잠긴 상태  */
    LOCKED,

    /** 계정의 soft-delete 상태  */
    DELETED,
}
