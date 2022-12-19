package endpoints

import endpoints.absences.AbsenceData
import endpoints.absences.AbsencesRq
import endpoints.absences.SickLeavesData
import endpoints.absences.SickLeavesRq
import endpoints.general.*
import endpoints.persons.PersonBaseData
import endpoints.persons.PersonsRq
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.resources.*
import io.ktor.client.statement.*
import io.ktor.resources.*
import io.ktor.util.reflect.*

@Suppress("unused")
interface HrWorksEndpoints {
    val client: HttpClient

    suspend fun getHolidays(rq: HolidaysRq): Map<String, HolidayData> = client.get(rq).body()
    suspend fun getAbsences(rq: AbsencesRq): Map<String, List<AbsenceData>> = client.get(rq).body()
    suspend fun getSickLeaves(rq: SickLeavesRq): Map<String, List<SickLeavesData>> = client.get(rq).body()
    suspend fun getPersons(rq: PersonsRq): Map<String, List<PersonBaseData>> = client.get(rq).body()

    suspend fun getOrganizationUnits(rq: OrganizationUnitsRq = OrganizationUnitsRq()): OrganizationUnitList =
        client.get(rq).body()

    suspend fun getOrganizationUnits(rq: OrganizationUnitsRq.Number): OrganizationUnit =
        client.get(rq).body()

    suspend fun getOrganizationUnits(rq: OrganizationUnitsRq.Number.PresentPersons): PersonsList =
        client.get(rq).body()

}
