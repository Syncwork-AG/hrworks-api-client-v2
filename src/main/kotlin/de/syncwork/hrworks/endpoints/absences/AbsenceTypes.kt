package de.syncwork.hrworks.endpoints.absences

import io.ktor.resources.*
import kotlinx.serialization.Serializable

@Serializable
@Resource("absences/absence-types")
data class AbsenceTypesRq @JvmOverloads constructor(
    val onlyActive: Boolean = false
)

@Serializable
data class AbsenceTypesData(
    val absenceTypes: List<AbsenceType>
)

@Serializable
data class AbsenceType(
    val name: String,
    val key: String,
    val isActive: Boolean,
    val reducesHolidayEntitlement: Boolean,
    val reducesTimeAccount: Boolean,
    val ignoreVacationBlackout: Boolean,
    val useInMonthPayroll: Boolean,
    val maxVacationDaysPerYear: Int = 0,
    val isSubstitutionMandatory: Boolean,
    val reducesTargetWorkingHours: Boolean,
    val color: String,
    val isAdminOnly: Boolean,
    val isPublic: Boolean,
)
