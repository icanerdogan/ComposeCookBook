pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
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

rootProject.name = "ComposeCookBook"
include(":app")
include(":anim")
include(":anim:canvas")
include(":anim:lottie")
include(":components")
include(":components:carousel")
include(":components:charts")
include(":components:colorpicker")
include(":components:fab")
include(":components:grid")
include(":components:util")
