//println("This is executed during the configuration phase")

//tasks.register("configured") {
//    println("This is also executed during the configuration phase, because :configured is used in the build")
//}
//
//tasks.register("test") {
//    doLast {
//        println("This is executed during the exercution phase")
//    }
//}
//
//tasks.register("testBoth") {
//    doFirst {
//        println("This is executed first during the exzecution phase")
//    }
//    doLast {
//        println("This is executed during the execution phase")
//    }
//    println("This is executed during the configuration phase as well, because :testBoth is used in the build")
//}

//gradle.beforeProject {
//    // Set a default value
//    project.ext.set("hasTests", false)
//}
//
//gradle.afterProject {
//    if (project.ext.has("hasTests") && project.ext.get("hasTests") as Boolean) {
//        val projectString = project.toString()
//        println("Adding test task to $projectString")
//        tasks.register("test") {
//            doLast {
//                println("Running tests for $projectString")
//            }
//        }
//    }
//}

tasks.register("ok")

tasks.register("broken") {
    dependsOn("ok")
    doLast {
        throw RuntimeException("broken")
    }
}

gradle.taskGraph.beforeTask {
    println("executing $this ...")
}

gradle.taskGraph.afterTask {
    if (state.failure != null) {
        println("FAILED")
    } else {
        println("done")
    }
}