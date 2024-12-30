plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}
rootProject.name = "pms"

include("runner")

include(":application:domain:product")
findProject(":application:domain:product")?.name = "product-domain"
include(":application:service:product")
findProject(":application:service:product")?.name = "product-service"

include("persistence:rdb")
include("persistence:redis")
include("web:http")
include("usecase:inbound")
include("usecase:outbound")
