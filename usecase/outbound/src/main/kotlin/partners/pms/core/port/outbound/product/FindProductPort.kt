package partners.pms.core.port.outbound.product

import partners.pms.application.domain.product.Product

interface FindProductPort {
    /**
     * 파라미터로 받은 검색조건을 모두 반영하여 상품을 조회합니다.
     * 모든 검색조건이 비어있는 경우 null을 반환합니다.
     *
     * @param id 상품 ID
     * @param code 상품 코드
     * @param name 상품명
     * @return 상품 정보
     */
    fun findProductBy(
        id: Long? = null,
        code: String? = null,
        name: String? = null,
    ): Product?
}
