package app.controller;


import app.App;
import app.JSONHelper;
import app.dao.CountryRepository;
import app.dao.PhoneRepository;
import app.service.CountryService;
import app.service.ReloadService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("test")
@Profile("test")
@SpringBootTest
public class SmokeTest {

    @Autowired
    private JSONHelper jsonHelper;

    @Value("${URL.COUNTRY}")
    String countryUrl;

    @Value("${URL.PHONE}")
    String phoneUrl;

    @Autowired
    ReloadDatabaseController reloadDatabaseController;

    @Autowired
    CountryController countryController;

    @Autowired
    ReloadService reloadService;

    @Autowired
    CountryService countryService;

    @Autowired
    CountryRepository countryRepository;

    @Autowired
    PhoneRepository phoneRepository;

    @Test
    public void testContexLoadJSONHelper() throws Exception {
        assertThat(jsonHelper).isNotNull();
    }

    @Test
    public void testCountryURL() {
        assertThat(countryUrl.equals("http://country.io/names.json")).isTrue();
    }

    @Test
    public void testPhoneURL() {
        assertThat(phoneUrl.equals("http://country.io/phone.json")).isTrue();
    }

    @Test
    public void testReloadDatabaseController(){
        assertThat(reloadDatabaseController).isNotNull();
    }

    @Test
    public void testCountryController(){
        assertThat(countryController).isNotNull();
    }

    @Test
    public void testReloadService(){
        assertThat(reloadService).isNotNull();
    }

    @Test
    public void testCountryService(){
        assertThat(countryService).isNotNull();
    }

    @Test
    public void testPhoneRepository(){
        assertThat(phoneRepository).isNotNull();
    }

    @Test
    public void testCountryRepository(){
        assertThat(countryRepository).isNotNull();
    }
}