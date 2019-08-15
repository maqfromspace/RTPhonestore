package app.service;

/**
 * Сервис, отвечающий за получение телефонного кода по названию страны
 */
public interface CountryService {
    /**
     * Метод получения телефонного кода по названию страны
     * @param countryName - название страны
     * @return - телефоный код. Возвразает null если код не найден.
     */
    String getCodeByCountryname(String countryName);
}
