package de.syncwork.hrworks.absences

import de.syncwork.hrworks.AbstractHrWorksTest
import de.syncwork.hrworks.endpoints.absences.AbsencesRq
import de.syncwork.hrworks.endpoints.absences.LeaveAccountDataRq
import de.syncwork.hrworks.endpoints.absences.SickLeavesRq
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.BeforeAll
import strikt.api.expectThat
import strikt.assertions.*
import java.time.LocalDate
import java.time.YearMonth
import kotlin.test.Test

class AbsencesTest : AbstractHrWorksTest() {

    @Test
    fun `response of getAbsences will have the requested person and date boundaries`(): Unit = runBlocking {
        val testPersons = listOf("190")
        val testBeginDate = LocalDate.now().withDayOfYear(1)
        val testEndDate = LocalDate.now().withMonth(12).withDayOfMonth(31)
        val result = client.getAbsences(
            AbsencesRq(
                testBeginDate, testEndDate, persons = testPersons, usePersonnelNumbers = true
            )
        )
        expectThat(result).containsKeys(*testPersons.toTypedArray()).and {
            get(testPersons.first()).withNotNull {
                all {
                    get { beginDate }.isEqualTo(testBeginDate)
                    get { endDate }.isEqualTo(testEndDate)
                }
            }
        }
    }

    @Test
    fun `response of getAbsenceTypes will not be empty`(): Unit = runBlocking {
        val result = client.getAbsenceTypes()
        expectThat(result.absenceTypes).isNotEmpty()
    }

    @Test
    fun `response of getLeaveAccountData will the requested person`(): Unit = runBlocking {
        val testPersons = listOf("190")
        val result = client.getLeaveAccountData(LeaveAccountDataRq(persons = testPersons, usePersonnelNumbers = true))
        expectThat(result).containsKeys(*testPersons.toTypedArray())
    }

    @Test
    fun `response of getSickLeaves will have the requested person and date boundaries`(): Unit = runBlocking {
        val testBeginDate = LocalDate.parse("2022-01-01")
        val testEndDate = LocalDate.parse("2022-12-31")
        val testPersons = listOf("190")
        val result = client.getSickLeaves(
            SickLeavesRq(
                testBeginDate, testEndDate, persons = testPersons, usePersonnelNumbers = true
            )
        )
        expectThat(result).containsKeys(*testPersons.toTypedArray()).and {
            get(testPersons.first()).withNotNull {
                all {
                    get { beginDate }.isEqualTo(testBeginDate)
                    get { endDate }.isEqualTo(testEndDate)
                }
            }
        }
    }

    @Test
    fun `response of getSickLeaveTypes will not be empty`(): Unit = runBlocking {
        val result = client.getSickLeaveTypes()
        expectThat(result.sickLeaveTypes).isNotEmpty()
    }
}
