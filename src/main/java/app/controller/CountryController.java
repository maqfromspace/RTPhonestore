package app.controller;

import app.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Контроллер для GET /code/${COUNTRYNAME}
 */
@RequestMapping("code")
@RestController
public class CountryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    @Autowired
    CountryService countryService;

    @GetMapping("{countryName}")
    public ResponseEntity getCodeByCountry(@PathVariable String countryName){
        LOGGER.info("Получен GET запрос GET /code/" + countryName);

        String correctCountryName =
                countryName.substring(0, 1).toUpperCase()
                + countryName.substring(1).toLowerCase();

        LOGGER.info("Название страны приведено к правильному виду:" + countryName + " -> " + countryName);
        LOGGER.info("CountryController обращается к CountryService для полуения записей телефонного кода для страны "
                + correctCountryName);

        String phone = countryService.getCodeByCountryname(correctCountryName);

        if(phone != null) {
            LOGGER.info("CountryService вернул код телефона " + phone + " для страны " + correctCountryName);
            return ResponseEntity.ok(phone);
        }
        else {
            LOGGER.info("CountryService не нашёл код телефона для страны " + correctCountryName);
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}