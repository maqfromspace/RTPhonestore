package app.dao;

import app.domain.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Репозиторий для работы с Country в БД
 */
public interface CountryRepository extends CrudRepository<Country, Long>{
    Country findByCountry(String country);
}
