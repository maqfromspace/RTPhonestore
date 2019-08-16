package app;

import app.controller.CountryController;
import app.service.ReloadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class Scheduler {
    private static final Logger LOGGER = LoggerFactory.getLogger(Scheduler.class);

    @Autowired
    ReloadService reloadService;

    @Scheduled(cron = "${time}",zone = "${timezone}")
    public void startReload(){
        LOGGER.info("Обновляем данные в БД по расписанию...");
        reloadService.reloadData();
    }
}
