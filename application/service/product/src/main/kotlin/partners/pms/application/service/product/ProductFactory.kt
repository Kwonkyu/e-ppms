package partners.pms.application.service.product

import partners.pms.application.domain.product.Product
import partners.pms.core.port.inbound.product.model.request.ProductCreateRequest
import partners.pms.core.port.inbound.product.model.response.CreatedProduct
import partners.pms.core.port.inbound.product.model.response.SearchedProduct
import java.util.UUID

class ProductFactory {
    object Inbound {
        /**
         * 상품 생성 요청 데이터로부터 상품 도메인을 생성합니다.
         *
         * @param request 상품 생성 요청 데이터
         * @return 상품 도메인
         */
        fun fromCreateRequest(request: ProductCreateRequest): Product =
            Product(
                id = -1,
                code = UUID.randomUUID().toString(),
                name = request.name,
                price = request.price,
            )

        /**
         * 상품 도메인으로부터 상품 생성 응답 데이터를 생성합니다.
         *
         * @param product 상품 도메인
         * @return 상품 생성 응답 데이터
         */
        fun toCreatedProduct(product: Product): CreatedProduct =
            CreatedProduct(
                id = product.id,
                code = product.code,
                name = product.name,
                price = product.price,
            )

        /**
         * 상품 도메인으로부터 상품 조회 응답 데이터를 생성합니다.
         *
         * @param product 상품 도메인
         * @return 상품 조회 응답 데이터
         */
        fun toSearchedProduct(product: Product): SearchedProduct =
            SearchedProduct(
                id = product.id,
                code = product.code,
                name = product.name,
                price = product.price,
            )
    }

    object Outbound
}
