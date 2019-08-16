package app;


import org.json.JSONException;
import org.json.JSONObject;
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

/**
 * Тест jsonhelper
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("test")
@SpringBootTest
public class JSONHelperTest {

    @Autowired
    JSONHelper jsonHelper;

    @Value("${URL.COUNTRY}")
    String countryUrl;

    @Value("${URL.PHONE}")
    String phoneUrl;

    @Test
    public void testJsonHelper() throws JSONException {
        JSONObject countryJSON = new JSONObject(jsonHelper.getJsonByURL(countryUrl));
        JSONObject phoneJSON = new JSONObject(jsonHelper.getJsonByURL(countryUrl));
        assertThat(countryJSON).isNotNull();
        assertThat(phoneJSON).isNotNull();
    }
}