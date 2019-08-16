package app.controller;

import app.service.ReloadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Контроллер для POST /reload
 */
@RestController
public class ReloadDatabaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    @Autowired
    ReloadService reloadService;

    @PostMapping("/reload")
    public ResponseEntity getCodeByCountry(){
        LOGGER.info("Получен POST запрос POST /upload");
        LOGGER.info("ReloadDatabaseController обращается к ReloadService для обновления данных в БД");
        reloadService.reloadData();
        return ResponseEntity.ok("База обновлена");
    }

}
