@file:UseSerializers(LocalDateSerializer::class)

package de.syncwork.hrworks.endpoints.absences

import de.syncwork.hrworks.core.LocalDateSerializer
import io.ktor.resources.*
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers
import java.time.LocalDate

@Serializable
@Resource("absences/leave-accounts")
data class LeaveAccountDataRq @JvmOverloads constructor(
    val referenceDate: LocalDate? = null,
    val persons: List<String> = emptyList(),
    val usePersonnelNumbers: Boolean = false,
)

@Serializable
data class LeaveAccountData(
    val holidayEntitlement: Int,
    val requested: Int,
    val approved: Int,
    val unplanned: Int,
    val planned: Int,
)