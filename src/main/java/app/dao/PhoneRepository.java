package app.dao;

import app.domain.Phone;
import org.springframework.data.repository.CrudRepository;

/**
 * Репозиторий для работы с Phone в БД
 */
public interface PhoneRepository extends CrudRepository<Phone, Long> {
    Phone findByCode(String code);
}
