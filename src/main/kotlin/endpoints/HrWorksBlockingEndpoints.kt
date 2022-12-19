package endpoints

import endpoints.absences.AbsencesRq
import endpoints.absences.SickLeavesRq
import endpoints.general.HolidaysRq
import endpoints.persons.PersonsRq
import kotlinx.coroutines.runBlocking

@Suppress("unused", "INAPPLICABLE_JVM_NAME")
interface HrWorksBlockingEndpoints : HrWorksEndpoints {

    @JvmName("getHolidays")
    fun getBlockingHolidays(rq: HolidaysRq) = runBlocking { getHolidays(rq) }

    @JvmName("getAbsences")
    fun getBlockingAbsences(rq: AbsencesRq) = runBlocking { getAbsences(rq) }

    @JvmName("getSickLeaves")
    fun getBlockingSickLeaves(rq: SickLeavesRq) = runBlocking { getSickLeaves(rq) }

    @JvmName("getPersons")
    fun getBlockingPersons(rq: PersonsRq) = runBlocking { getPersons(rq) }
}
