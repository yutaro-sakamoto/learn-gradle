import org.apache.commons.codec.binary.Base64

tasks.register("hello") {
    doLast {
        println("Hello world!");
    }
}

tasks.register("upper") {
    doLast {
        val someString = "mY_nAmE"
        println("Original: $someString")
        println("Upper case: ${someString.toUpperCase()}")
    }
}

tasks.register("count") {
    doLast {
        repeat(4) {
            print("$it ")
        }
    }
}

tasks.register("intro") {
    dependsOn("hello")
    doLast {
        println("I'm gradle")
    }
}

tasks.register("taskX") {
    dependsOn("taskY")
    doLast {
        println("taskX")
    }
}

tasks.register("taskY") {
    doLast {
        println("taskY")
    }
}

repeat(4) { counter ->
    tasks.register("task$counter") {
        doLast {
            println("I'm task number $counter")
        }
    }
}

tasks.named("task0") {
    dependsOn("task2", "task3")
}

tasks.named("hello") {
    doLast {
        println("Hello Earth")
    }
}

tasks.named("hello") {
    doLast {
        println("Hello Venus")
    }
}

defaultTasks("clean", "run")

tasks.register("clean") {
    doLast {
        println("Default Cleaning!")
    }
}

tasks.register("run") {
    doLast {
        println("Default Running!")
    }
}

buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        "classpath"(group = "commons-codec", name = "commons-codec", version = "1.2")
    }
}

tasks.register("encode") {
    doLast {
        val encodedString = Base64().encode("hello world\n".toByteArray())
        println(String(encodedString))
    }
}