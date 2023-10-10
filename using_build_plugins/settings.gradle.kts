//include("hello-a")
//include("hello-b")
//include("goodbye-c")

pluginManagement {
    val helloPluginVersion: String by settings
    plugins {
        id("com.example.hello") version "${helloPluginVersion}"
    }
    resolutionStrategy {
        eachPlugin {
            if (requested.id.namespace == "com.example") {
                useModule("com.example:sample-plugins:1.0.0")
            }
        }
    }
    repositories {
        maven(url = "./maven-repo")
        gradlePluginPortal()
        ivy(url = "./ivy-repo")
    }
}
rootProject.name = "plugin-management"