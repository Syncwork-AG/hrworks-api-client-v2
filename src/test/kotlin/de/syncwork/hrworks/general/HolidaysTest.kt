package de.syncwork.hrworks.general

import de.syncwork.hrworks.AbstractHrWorksTest
import de.syncwork.hrworks.endpoints.general.HolidaysRq
import kotlinx.coroutines.runBlocking
import strikt.api.expectThat
import strikt.assertions.containsKeys
import kotlin.test.Test

class TestHolidays : AbstractHrWorksTest() {
    @Test
    fun testHolidays(): Unit = runBlocking {
        val result =
            client.getHolidays(HolidaysRq(2022))

        expectThat(result).containsKeys("CHE", "AUT", "DEU")

    }
}