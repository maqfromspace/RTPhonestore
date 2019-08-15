package app;

import app.domain.Country;
import app.domain.Phone;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Вспомогательный класс для работы JSON
 */
@Component
public class JSONHelper {
    private static final Logger LOGGER = LoggerFactory.getLogger(JSONHelper.class);

    @Value("${URL.COUNTRY}")
    String countryUrl;
    @Value("${URL.PHONE}")
    String phoneUrl;

    HttpURLConnection connection;

    /**
     * Полуение json с источника
     * @param urlString - url источника
     * @return Строковое представление json
     */
    public String getJsonByURL(String urlString) {
        try {
            LOGGER.info("Начинаем получение JSON с источника " + urlString + "...");
            URL url = new URL(urlString);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            String result = IOUtils.toString(connection.getInputStream(), StandardCharsets.UTF_8);
            connection.disconnect();
            LOGGER.info("JSON с источника " + urlString + " получен");
            return result;
        } catch (Exception e) {
            LOGGER.error("При получении JSON с " + urlString + " возникло исключение:\n" + e.getMessage());
            if (connection != null)
                connection.disconnect();
            return null;
        }
    }

    /**
     * Получение списка сущностей Country с источников
     * @return список Country
     */
    public List<Country> getCountries(){
        List<Country> countries = new ArrayList<Country>();
        String jsonString = getJsonByURL(countryUrl);
        JSONObject json = new JSONObject(jsonString);
        Set<String> keys = json.keySet();
        keys.forEach(key -> {
            countries.add(
                    new Country(key,json.getString(key)));
        });
        return countries;
    }

    /**
     * Получение списка сущностей Phone с источников
     * @return список Phone
     */
    public List<Phone> getPhones(){
        List<Phone> phones = new ArrayList<Phone>();
        String jsonString = getJsonByURL(phoneUrl);
        JSONObject json = new JSONObject(jsonString);
        Set<String> keys = json.keySet();
        keys.forEach(key -> {
            phones.add(
                    new Phone(key,json.getString(key)));
        });
        System.out.println(phones);
        return phones;
    }
}
