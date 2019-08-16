package app;

import app.service.ReloadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * CommandLineRunner заполняющий БД данными после инициализации Spring контекста
 */
@Component
@Profile("!test")
public class CommandLineAppStartupRunner implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(JSONHelper.class);

    @Autowired
    ReloadService reloadService;

    @Override
    public void run(String...args) throws Exception {
        LOGGER.info("Загружаем данные в БД при запуске приложения..");
        reloadService.reloadData();
    }
}