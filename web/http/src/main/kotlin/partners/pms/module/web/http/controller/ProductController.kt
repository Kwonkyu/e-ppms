@file:Suppress("ktlint:standard:no-wildcard-imports")

package partners.pms.module.web.http.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import partners.pms.core.port.inbound.product.CreateProductPort
import partners.pms.core.port.inbound.product.FindProductPort
import partners.pms.core.port.inbound.product.model.request.ProductCreateRequest
import partners.pms.module.web.http.model.product.ProductCreateHttpRequest
import java.net.URI

@RestController
@RequestMapping("/product")
class ProductController(
    private val createProductPort: CreateProductPort,
    private val findProductPort: FindProductPort,
) {
    @GetMapping("/{code}")
    fun getProduct(
        @PathVariable code: String,
    ): ResponseEntity<String> {
        val product = findProductPort.findByCode(code)
        return if (product != null) {
            ResponseEntity.ok(product.toString())
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @PostMapping("/new")
    fun createNewProduct(
        @RequestBody request: ProductCreateHttpRequest,
    ): ResponseEntity<String> =
        createProductPort
            .createProduct(ProductCreateRequest(request.name, request.price))
            .let { ResponseEntity.created(URI.create("/$it")).build() }
}
