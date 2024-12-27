plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}
rootProject.name = "pms"
include("application")
include("persistence:rdb")
include("persistence:redis")
include("web:http")
