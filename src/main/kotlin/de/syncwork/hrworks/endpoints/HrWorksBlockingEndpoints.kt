package de.syncwork.hrworks.endpoints

import de.syncwork.hrworks.endpoints.absences.*
import de.syncwork.hrworks.endpoints.general.HolidaysRq
import de.syncwork.hrworks.endpoints.general.OrganizationUnitsRq
import de.syncwork.hrworks.endpoints.persons.PersonsRq
import kotlinx.coroutines.runBlocking

/**
 * These methods are wrapper functions to get access to their pendants in [HrWorksEndpoints] from Java code.
 */
@Suppress("unused", "INAPPLICABLE_JVM_NAME")
interface HrWorksBlockingEndpoints : HrWorksEndpoints {

    @JvmName("getHolidays")
    fun getBlockingHolidays(rq: HolidaysRq) = runBlocking { getHolidays(rq) }

    @JvmName("getAbsences")
    fun getBlockingAbsences(rq: AbsencesRq) = runBlocking { getAbsences(rq) }

    @JvmName("getAbsenceTypes")
    fun getBlockingAbsenceTypes(rq: AbsenceTypesRq) = runBlocking { getAbsenceTypes(rq) }

    @JvmName("getAbsenceTypes")
    fun getBlockingAbsenceTypes() = runBlocking { getAbsenceTypes() }

    @JvmName("getSickLeaves")
    fun getBlockingSickLeaves(rq: SickLeavesRq) = runBlocking { getSickLeaves(rq) }

    @JvmName("getSickLeaveTypes")
    fun getBlockingSickLeaveTypes(rq: SickLeaveTypesRq) = runBlocking { getSickLeaveTypes(rq) }

    @JvmName("getSickLeaveTypes")
    fun getBlockingSickLeaveTypes() = runBlocking { getSickLeaveTypes() }

    @JvmName("getLeaveAccountData")
    fun getBlockingLeaveAccountData(rq: LeaveAccountDataRq) = runBlocking { getLeaveAccountData(rq) }

    @JvmName("getLeaveAccountData")
    fun getBlockingLeaveAccountData() = runBlocking { getLeaveAccountData() }

    @JvmName("getPersons")
    fun getBlockingPersons(rq: PersonsRq) = runBlocking { getPersons(rq) }

    @JvmName("getPersons")
    fun getBlockingPersons() = runBlocking { getPersons() }

    @JvmName("getOrganizationUnits")
    fun getBlockingOrganizationUnits(rq: OrganizationUnitsRq) = runBlocking { getOrganizationUnits(rq) }

    @JvmName("getOrganizationUnits")
    fun getBlockingOrganizationUnits() = runBlocking { getOrganizationUnits() }

    @JvmName("getOrganizationUnits")
    fun getBlockingOrganizationUnits(rq: OrganizationUnitsRq.Number) = runBlocking { getOrganizationUnits(rq) }

    @JvmName("getOrganizationUnits")
    fun getBlockingOrganizationUnits(rq: OrganizationUnitsRq.Number.PresentPersons) =
        runBlocking { getOrganizationUnits(rq) }
}
