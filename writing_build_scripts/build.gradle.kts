plugins {
    id("java-library")
}

//tasks.register("check") {
//    doLast() {
//        println(name)
//        println(project.name)
//    }
//}

val dest = "dest"
tasks.register<Copy>("copy") {
    from("source")
    into(dest)
}

val springVersion by extra("3.1.0.RELEASE")
val emailNotification by extra { "build@master.org" }

sourceSets.all { extra["purpose"] = null }

sourceSets {
    main {
        extra["purpose"] = "production"
    }
    test {
        extra["purpose"] = "test"
    }
    create("plugin") {
        extra["purpose"] = "production"
    }
}

tasks.register("printProperties") {
    val springVersion = springVersion
    val emailNotification = emailNotification
    val productionSourceSets = provider {
        sourceSets.matching { it.extra["purpose"] == "production" }.map{ it.name }
    }

    doLast {
        println(springVersion)
        println(emailNotification)
        productionSourceSets.get().forEach { println(it) }
    }
}

class UserInfo(
    var name: String? = null,
    var email: String? = null
)

tasks.register("configure") {
    val user = UserInfo().apply {
        name = "Isacc Newton"
        email = "isacc@newton.me"
    }
    doLast {
        println(user.name)
        println(user.email)
    }
}
