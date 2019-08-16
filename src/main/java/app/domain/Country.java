package app.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Сущность страны
 */
@Entity
@Table(schema = "public",name = "table_name")
public class Country {
    @Id
    String code;
    String country;

    public Country() {
    }

    public Country(String code, String country) {
        this.code = code;
        this.country = country;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Страна{" +
                "код='" + code + '\'' +
                ", страна='" + country + '\'' +
                '}';
    }
}
