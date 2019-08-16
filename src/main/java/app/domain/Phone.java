package app.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Сущность телефона
 */
@Entity
@Table(schema = "public",name = "phone")
public class Phone {
    @Id
    String code;
    String phone;

    public Phone() {
    }

    public Phone(String code, String phone) {
        this.code = code;
        this.phone = phone;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Телефон{" +
                "код='" + code + '\'' +
                ", телефон='" + phone + '\'' +
                '}';
    }
}
