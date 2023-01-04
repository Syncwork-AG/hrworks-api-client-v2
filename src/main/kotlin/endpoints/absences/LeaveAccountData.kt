package endpoints.absences

import io.ktor.resources.*
import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable

@Serializable
@Resource("absences/leave-accounts")
data class LeaveAccountDataRq(
    val persons: List<String> = emptyList(),
    val referenceDate: LocalDate? = null,
    val usePersonnelNumbers: Boolean = true,
    val page: Int? = null
)

@Serializable
data class LeaveAccountData(
    val holidayEntitlement: Int,
    val requested: Int,
    val approved: Int,
    val unplanned: Int,
    val planned: Int,
)