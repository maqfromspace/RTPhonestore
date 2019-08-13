package app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReloadDatabaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(GetCountryController.class);

    @PostMapping("/reload")
    public ResponseEntity getCodeByCountry(){
        LOGGER.info("Получен POST запрос POST /upload");
        return ResponseEntity.ok("База обновлена");
    }

}
