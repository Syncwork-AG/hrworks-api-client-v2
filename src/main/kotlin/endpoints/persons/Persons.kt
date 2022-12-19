package endpoints.persons

import io.ktor.resources.*
import kotlinx.serialization.Serializable

@Serializable
@Resource("persons")
data class PersonsRq @JvmOverloads constructor(
    val organizationUnits: List<String> = emptyList(),
    val onlyActive: Boolean = true
)

@Serializable
data class PersonBaseData(
    val personnelNumber: String,
    val personId: String,
    val firstName: String,
    val lastName: String
)