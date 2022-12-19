package endpoints.absences

import endpoints.persons.PersonBaseData
import io.ktor.resources.*
import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable

@Serializable
@Resource("sick-leaves")
data class SickLeavesRq @JvmOverloads constructor(
    val beginDate: LocalDate,
    val endDate: LocalDate,
    val persons: List<String> = emptyList(),
    val usePersonnelNumbers: Boolean = false,
    val interval: IntervalType? = null,
    val statusFilter: List<StatusFilter> = emptyList()
) {
    val count = true
}

@Serializable
data class SickLeavesData(
    val beginDate: LocalDate,
    val endDate: LocalDate,
    val sickLeaves: List<SickLeave>
)

@Serializable
data class SickLeave(
    val number: String,
    val beginDate: LocalDate,
    val endDate: LocalDate,
    val type: String,
    val name: String,
    val isBeginDateHalfDay: Boolean,
    val isForenoonHalfDay: Boolean,
    val isAfternoonHalfDay: Boolean,
    val isEndDateHalfDay: Boolean,
    val status: String,
    val workingDays: Float,
    val substitute: PersonBaseData
)
