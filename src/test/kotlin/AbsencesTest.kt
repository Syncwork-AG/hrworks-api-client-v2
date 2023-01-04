import endpoints.absences.*
import kotlinx.coroutines.runBlocking
import strikt.api.expectThat
import kotlinx.datetime.LocalDate
import strikt.assertions.*
import java.util.random.RandomGeneratorFactory.all
import kotlin.test.Test

class AbsencesTest : AbstractHrWorksTest() {
    @Test
    fun `response of getAbsences will have keys CHE, AUT and DEU`(): Unit = runBlocking {
        val result = client.getAbsences(
            AbsencesRq(
                LocalDate.parse("2022-01-01"), LocalDate.parse("2022-12-31"), usePersonnelNumbers = true
            )
        )
        expectThat(result).containsKeys("CHE", "AUT", "DEU")
    }

    @Test
    fun `response of getAbsenceTypes will not be empty`(): Unit = runBlocking {
        val result = client.getAbsenceTypes()
        expectThat(result.absenceTypes).isNotEmpty()
    }

    @Test
    fun `response of getLeaveAccountData will the requested person`(): Unit = runBlocking {
        val testPersons = listOf("1")
        val result = client.getLeaveAccountData(LeaveAccountDataRq(persons = testPersons, usePersonnelNumbers = true))
        expectThat(result).containsKeys(*testPersons.toTypedArray())
    }

    @Test
    fun `response of getSickLeaves will have the requested person and date boundaries`(): Unit = runBlocking {
        val testBeginDate = LocalDate.parse("2022-01-01")
        val testEndDate = LocalDate.parse("2022-12-31")
        val testPersons = listOf("1")
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