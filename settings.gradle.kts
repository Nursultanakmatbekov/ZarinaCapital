pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "ZarinaCapital"
include(":app")
include(":core:common")
include(":core:data")
include(":core:theme")
include(":core:presentation")
include(":core:di")
include(":forex-api")
include(":data:auth")
include(":data:courses")
include(":data:my-courses")
include(":data:menu")
include(":domain:auth")
include(":features:auth")
include(":features:courses")
include(":features:my-courses")
include(":features:menu")
