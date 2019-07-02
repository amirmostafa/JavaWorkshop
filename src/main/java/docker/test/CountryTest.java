package docker.test;

import docker.services.CountryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
public class CountryTest {

    @Autowired
    CountryService countryService;

    @Test
    public void testCountryCodeExist() {
        assertEquals("INVALID_COUNTRY_CODE", countryService.getCountryByCode("THULD").getReplyMessage());
    }

    @Test
    public void testDataBaseFailed() {
        assertEquals("INTERNAL_ERROR", countryService.getCountryByCode("BHR").getReplyMessage());
    }
}
