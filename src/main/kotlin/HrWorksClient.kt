package de.syncwork.hrworks

import de.syncwork.hrworks.core.AuthCredentials
import de.syncwork.hrworks.core.TokenInfo
import de.syncwork.hrworks.endpoints.HrWorksBlockingEndpoints
import de.syncwork.hrworks.endpoints.HrWorksEndpoints
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.java.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.auth.*
import io.ktor.client.plugins.auth.providers.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.plugins.resources.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.serialization.json.Json

class HrWorksClient @JvmOverloads constructor(
    apiKey: String,
    apiKeySecret: String,
    private val apiEndpoint: String = "api.hrworks.de",
    loglevel: LogLevel = LogLevel.NONE
) : HrWorksEndpoints, HrWorksBlockingEndpoints, AutoCloseable {
    private val credentials = AuthCredentials(apiKey, apiKeySecret)

    override val client = HttpClient(Java) {
        sharedClientConfig()
        install(Auth) {
            bearer {
                loadTokens { BearerTokens(getToken().encodedToken, "") }
            }
        }
        install(Logging) {
            logger = Logger.DEFAULT
            level = loglevel
        }
        install(Resources)
    }

    private val tokenClient = HttpClient(Java) {
        sharedClientConfig()
    }

    private fun HttpClientConfig<JavaHttpConfig>.sharedClientConfig() {
        expectSuccess = true
        defaultRequest {
            url(
                scheme = URLProtocol.HTTPS.name,
                host = apiEndpoint,
                path = "/v2/"
            )
            headers {
                append(HttpHeaders.Accept, "application/json")
            }
            contentType(ContentType.Application.Json)
        }
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                prettyPrint = true
                isLenient = true
            })
        }
    }

    private suspend fun HttpClient.requestToken(credentials: AuthCredentials): TokenInfo {
        return post("authentication") { setBody(credentials) }.body()
    }

    private var token: TokenInfo? = null
    private val tokenMutex = Mutex()

    private suspend fun getToken(): TokenInfo = token.let { currentToken ->
        if (currentToken != null && !currentToken.isExpired()) currentToken
        else tokenMutex.withLock {
            val cachedInsideLock = token
            if (cachedInsideLock != null && !cachedInsideLock.isExpired()) {
                cachedInsideLock
            } else {
                tokenClient.requestToken(credentials).also { token = it }
            }
        }
    }

    override fun close(): Unit = client.close()
}