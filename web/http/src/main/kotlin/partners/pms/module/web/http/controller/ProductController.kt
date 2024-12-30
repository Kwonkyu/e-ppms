@file:Suppress("ktlint:standard:no-wildcard-imports")

package partners.pms.module.web.http.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import partners.pms.core.port.inbound.product.CreateProductPort
import partners.pms.core.port.inbound.product.FindProductPort
import partners.pms.core.port.inbound.product.UpdateProductPort
import partners.pms.core.port.inbound.product.model.request.ProductCreateRequest
import partners.pms.core.port.inbound.product.model.request.ProductUpdateRequest
import partners.pms.module.web.http.model.product.ProductCreateHttpRequest
import partners.pms.module.web.http.model.product.ProductUpdateHttpRequest
import java.net.URI

@RestController
@RequestMapping("/product")
class ProductController(
    private val createProductPort: CreateProductPort,
    private val updateProductPort: UpdateProductPort,
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
            .let { ResponseEntity.created(URI.create("/${it.code}")).build() }

    @PatchMapping("/{code}")
    fun updateProduct(
        @PathVariable code: String,
        @RequestBody request: ProductUpdateHttpRequest,
    ): ResponseEntity<Boolean> {
        updateProductPort.updateProduct(code, ProductUpdateRequest(request.name, request.price))
        return ResponseEntity.ok(true)
    }
}
