package de.syncwork.hrworks.absences

import de.syncwork.hrworks.AbstractHrWorksTest
import de.syncwork.hrworks.endpoints.absences.LeaveAccountDataRq
import kotlinx.coroutines.runBlocking
import strikt.api.expectThat
import strikt.assertions.containsKeys
import java.time.LocalDate
import kotlin.test.Test

class LeaveAccountDataTest : AbstractHrWorksTest() {
    @Test
    fun `response of getAbsences will have the requested person`(): Unit = runBlocking {
        val testPersons = listOf("1")
        val testReferenceDate = LocalDate.parse("2022-01-01")
        val result = client.getLeaveAccountData(
            LeaveAccountDataRq(
                testReferenceDate, persons = testPersons, usePersonnelNumbers = true
            )
        )
        expectThat(result).containsKeys(*testPersons.toTypedArray())
    }
}