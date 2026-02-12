package de.syncwork.hrworks.endpoints.absences

import io.ktor.resources.*
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
    val isAdminOnly: Boolean,
    val isPublic: Boolean,
    val isSicknessOfChild: Boolean,
)
