package de.syncwork.hrworks.core

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import java.nio.charset.StandardCharsets
import java.util.Base64

@Serializable
data class TokenInfo(@SerialName("token") val encodedToken: String) {
    companion object {
        private val tokenJson = Json { ignoreUnknownKeys = true }
    }

    val payload by lazy {
        tokenJson.decodeFromString<JwtPayload>(
            String(
                Base64.getDecoder().decode(encodedToken.split(".")[1]),
                StandardCharsets.UTF_8
            )
        )
    }

    fun isExpired(): Boolean = payload.expires < (System.currentTimeMillis() / 1000)
}

@Serializable
data class JwtPayload(
    @SerialName("iss")
    val issuer: String,
    @SerialName("exp")
    val expires: Long,
    @SerialName("nbf")
    val notBefore: Long,
    @SerialName("iat")
    val issued: Long,
    @SerialName("jti")
    val jwtId: String,
    @SerialName("accessKeyId")
    val accessKey: String,
)

@Serializable
data class AuthCredentials(val accessKey: String, val secretAccessKey: String)