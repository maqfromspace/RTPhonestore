package app.service;

import app.JSONHelper;
import app.controller.CountryController;
import app.dao.CountryRepository;
import app.dao.PhoneRepository;
import app.domain.Country;
import app.domain.Phone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReloadServiceImplementation implements ReloadService{

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    @Autowired
    JSONHelper jsonHelper;

    @Autowired
    CountryRepository countryRepository;

    @Autowired
    PhoneRepository phoneRepository;

    @Override
    public void reloadData() {
        LOGGER.info("Загружаем данные с источников...");
        List<Country> countries = jsonHelper.getCountries();
        List<Phone> phones = jsonHelper.getPhones();

        LOGGER.info("Очищаем таблицы от старых данных...");
        countryRepository.deleteAll();
        phoneRepository.deleteAll();

        LOGGER.info("Сохранием новые данные...");
        countryRepository.saveAll(countries);
        phoneRepository.saveAll(phones);
        LOGGER.info("Данные сохранены");
    }
}
