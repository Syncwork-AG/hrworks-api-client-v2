package endpoints.absences

import io.ktor.resources.*
import kotlinx.serialization.Serializable
import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName

@Serializable
@Resource("absences")
data class AbsencesRq @JvmOverloads constructor(
    val beginDate: LocalDate,
    val endDate: LocalDate,
    val persons: List<String> = emptyList(),
    val usePersonnelNumbers: Boolean = false,
    val interval: IntervalType? = null,
    val statusFilter: List<StatusFilter> = emptyList()
) {
    val count = false
}

@Serializable
enum class IntervalType {
    @SerialName("days") DAYS,
    @SerialName("weeks") WEEKS,
    @SerialName("month") MONTH
}

@Serializable
enum class StatusFilter {
    @SerialName("substitutionRequested") SUBSTITUTION_REQUESTED,
    @SerialName("cancellationRequested") CANCELLATION_REQUESTED,
    @SerialName("cancelled") CANCELLED,
    @SerialName("changesRequested") CHANGES_REQUESTED,
    @SerialName("editingChanges") EDITING_CHANGES,
    @SerialName("deletionRequested") DELETION_REQUESTED,
    @SerialName("editing") EDITING,
    @SerialName("substitutionRejected") SUBSTITUTION_REJECTED,
    @SerialName("requested") REQUESTED,
    @SerialName("validatedOk") VALIDATED_OK,
    @SerialName("validatedNotOk") VALIDATED_NOT_OK
}

@Serializable
data class AbsenceData(
    val beginDate: LocalDate,
    val endDate: LocalDate,
    val absences: List<Absence>
)

@Serializable
data class Absence(
    val type: String,
    val beginDate: String,
    val endDate: String,
    val isAfternoonHalfDay: Boolean,
    val isForenoonHalfDay: Boolean,
    val name: String,
    val number: String,
    val status: String,
    val workingDays: Float
)