package endpoints.absences

import endpoints.persons.PersonBaseData
import io.ktor.resources.*
import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable

@Serializable
@Resource("sick-leaves/sick-leave-types")
data class SickLeaveTypesRq @JvmOverloads constructor(
    val onlyActive: Boolean = false
)

@Serializable
data class SickLeaveTypesData(
    val sickLeaveTypes: List<SickLeaveType>
)

@Serializable
data class SickLeaveType(
    val name: String,
    val key: String,
    val isActive: Boolean,
    val color: String,
    val isAdminOnly: Boolean,
    val isPublic: Boolean,
    val isSicknessOfChild: Boolean,
)
