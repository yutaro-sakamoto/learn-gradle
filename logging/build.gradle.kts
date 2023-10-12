import org.slf4j.LoggerFactory

println("A message which is logged at QUIET level")

logger.quiet("An info log message which is always logged")
logger.error("An error log message")
logger.warn("A warn log message")
logger.lifecycle("A lifecycle info log message")
logger.info("An info log message")
logger.debug("A debug log message")
logger.trace("A trace log message")

logger.info("A {} log message", "info")

val slf4jLogger = LoggerFactory.getLogger("some-logger")
slf4jLogger.info("An info log message logged using SLF4j")

logging.captureStandardOutput(LogLevel.INFO)
println("A message which is logged at INFO level")

tasks.register("logInfo") {
    logging.captureStandardOutput(LogLevel.INFO)
    doFirst {
        println("A task message which is logged at INFO level")
    }
}