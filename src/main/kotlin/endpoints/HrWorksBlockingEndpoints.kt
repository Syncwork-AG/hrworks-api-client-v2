package endpoints

import endpoints.absences.*
import endpoints.general.HolidaysRq
import endpoints.persons.PersonsRq
import io.ktor.client.call.*
import io.ktor.client.plugins.resources.*
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
}
