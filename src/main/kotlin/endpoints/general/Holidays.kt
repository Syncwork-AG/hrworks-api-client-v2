package endpoints.general

import io.ktor.resources.Resource
import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable

@Serializable
@Resource("holidays")
data class HolidaysRq @JvmOverloads constructor(
    val year: Int,
    val countryCodes: List<String>? = null,
    val permanentEstablishments: List<String>? = null,
)

@Serializable
data class HolidayData(
    val permanentEstablishmentHolidays: Map<String, List<Holiday>> = mapOf(),
    val stateHolidays: Map<String, List<Holiday>> = mapOf(),
    val generalHolidays: List<Holiday> = listOf(),
)

@Serializable
data class Holiday(
    val date: LocalDate,
    val isHalfDay: Boolean,
    val name: String,
)