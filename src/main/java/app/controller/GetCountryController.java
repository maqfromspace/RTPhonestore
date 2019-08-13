package app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("code")
@RestController
public class GetCountryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(GetCountryController.class);

    @GetMapping("{country}")
    public ResponseEntity getCodeByCountry(@PathVariable String country){
        LOGGER.info("Получен GET запрос GET /code/" + country);
        return ResponseEntity.ok(country);
    }
}
