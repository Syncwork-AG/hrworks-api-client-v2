package de.syncwork.hrworks

val apiKey = System.getenv("apiKey") ?: throw IllegalArgumentException()
val apiKeySecret = System.getenv("apiKeySecret") ?: throw IllegalArgumentException()
val apiEndpoint = System.getenv("apiEndpoint") ?: throw IllegalArgumentException()

open class AbstractHrWorksTest {
    companion object {
        val client: HrWorksClient = HrWorksClient(apiKey, apiKeySecret, apiEndpoint)
    }
}
