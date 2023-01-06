@file:UseSerializers(LocalDateSerializer::class)

package de.syncwork.hrworks.endpoints.absences

import de.syncwork.hrworks.core.LocalDateSerializer
import de.syncwork.hrworks.endpoints.persons.PersonBaseData
import io.ktor.resources.*
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers
import java.time.LocalDate

@Serializable
@Resource("sick-leaves")
data class SickLeavesRq @JvmOverloads constructor(
    val beginDate: LocalDate,
    val endDate: LocalDate,
    val persons: List<String> = emptyList(),
    val interval: IntervalType? = null,
    val usePersonnelNumbers: Boolean = false,
    val statusFilter: List<StatusFilter> = emptyList()
) {
    val count = false
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
