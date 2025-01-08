package enum

enum class AccountStatus {
    ACTIVE, // 정상 활성상태
    DORMANT, // 장기 미접속 휴면상태
    LOCKED, // 계정 초기생성 또는 로그인 실패로 잠긴 상태
    DELETED, // 계정의 soft-delete 상태
}
