plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}
rootProject.name = "e-ppms"

include("runner")

include(":application:domain:product")
findProject(":application:domain:product")?.name = "product-domain"
include(":application:service:product")
findProject(":application:service:product")?.name = "product-service"

include(":application:domain:account")
findProject(":application:domain:account")?.name = "account-domain"
include("application:service:account")
findProject(":application:service:account")?.name = "account-service"

include("persistence:rdb")
include("persistence:redis")
include("web:http")
include("usecase:inbound")
include("usecase:outbound")
