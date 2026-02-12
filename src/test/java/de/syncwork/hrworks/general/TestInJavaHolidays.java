package de.syncwork.hrworks.general;

import de.syncwork.hrworks.HrWorksClient;
import de.syncwork.hrworks.endpoints.general.HolidaysRq;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestInJavaHolidays {

    String apiKey = System.getenv("apiKey");
    String apiKeySecret = System.getenv("apiKeySecret");
    String apiEndpoint = System.getenv("apiEndpoint");

    @Test
    void testHolidays() {
        try (var client = new HrWorksClient(apiKey, apiKeySecret, apiEndpoint)) {
            var result = client.getHolidays(new HolidaysRq(2022));

            assertThat(result).containsKeys("CHE", "DEU");
        }

    }
}
