package app.service;

import app.controller.CountryController;
import app.dao.CountryRepository;
import app.dao.PhoneRepository;
import app.domain.Country;
import app.domain.Phone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CountryServiceImplementation implements CountryService{

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    @Autowired
    CountryRepository countryRepository;

    @Autowired
    PhoneRepository phoneRepository;

    @Override
    public String getCodeByCountryname(String countryName) {
        LOGGER.info("CountryService обращается к CountryRepository для получения сущности Country c названием страны "
                + countryName);

        Country country = countryRepository.findByCountry(countryName);

        if(country != null) {
            LOGGER.info("Получена сущность Country :"
                    + country);

            String code = country.getCode();

            LOGGER.info("CountryService обращается к PhoneRepository для получения сущности Phone c кодом страны  "
                    + code);

            Phone phone = phoneRepository.findByCode(code);


            if (phone != null) {
                LOGGER.info("Получена сущность Phone c кодом страны  " + code);
                LOGGER.info("CountryService для страны " + countryName + " нашел код телефона " + phone.getPhone());
                return phone.getPhone();
            }
            else {
                LOGGER.info("PhoneRepository не нашел Phone c кодом страны " + countryName);
                return null;
            }
        }
        else {
            LOGGER.info("CountryRepository не нашел Country c названием страны " + countryName);
            return null;
        }
    }
}
