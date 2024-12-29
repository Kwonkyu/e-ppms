plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}
rootProject.name = "pms"
include("runner")
include("application:product")
findProject(":application:product")?.name = "application-product"
include("persistence:rdb")
include("persistence:redis")
include("web:http")
include("usecase:inbound")
include("usecase:outbound")
include("domain:product")
findProject(":domain:product")?.name = "domain-product"
