import endpoints.absences.AbsencesRq
import kotlinx.coroutines.runBlocking
import strikt.api.expectThat
import strikt.assertions.containsKeys
import kotlinx.datetime.LocalDate
import kotlin.test.Test

class AbsencesTest : AbstractHrWorksTest() {
    @Test
    fun testAbsences(): Unit = runBlocking {
        val result =
            client.getAbsences(AbsencesRq(LocalDate.parse("2022-01-01"), LocalDate.parse("2022-12-31")))

        expectThat(result).containsKeys("CHE", "AUT", "DEU")

    }
}