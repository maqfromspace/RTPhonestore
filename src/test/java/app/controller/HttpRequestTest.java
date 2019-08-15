package app.controller;

import app.dao.CountryRepository;
import app.dao.PhoneRepository;
import app.domain.Country;
import app.domain.Phone;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//Тест контроллера
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HttpRequestTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    CountryRepository countryRepository;

    @Autowired
    PhoneRepository phoneRepository;

    @Test
    public void testGetPhoneByRightCountry() throws Exception {
        //Создаем тестовые сущности
        Country country = new Country("TST","Testcountry");
        Phone phone = new Phone("TST","+999");

        //Записываем их в базу данных
        countryRepository.save(country);
        phoneRepository.save(phone);

        //Отправляем get запрос /code/Testcountry
        MvcResult result1 = this.mockMvc
                .perform(get("/code/Testcountry"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        String content1 = result1.getResponse().getContentAsString();


        //Отправляем get запрос /code/testcountry
        MvcResult result2 = this.mockMvc
                .perform(get("/code/testcountry"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        String content2 = result2.getResponse().getContentAsString();
        assertThat(content2.equals(phone.getPhone())).isTrue();

        //Отправляем get запрос /code/TESTCOUNTRY
        MvcResult result3 = this.mockMvc
                .perform(get("/code/TESTCOUNTRY"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        String content3 = result3.getResponse().getContentAsString();

        //Проверяем результат выполнения запроса
        assertThat(content1.equals(phone.getPhone())).isTrue();
        assertThat(content2.equals(phone.getPhone())).isTrue();
        assertThat(content3.equals(phone.getPhone())).isTrue();

        //Удаляем тестовые записи из БД
        countryRepository.delete(country);
        phoneRepository.delete(phone);
    }

    @Test
    public void getPhoneByWrongCountry() throws Exception {

        //Отправляем запрос get /code/Rusqwsiaasdqqwsaczx и проверяем то, что в статус будет равен 404
        this.mockMvc
                .perform(get("/code/Rusqwsiaasdqqwsaczx"))
                .andDo(print())
                .andExpect(status().isNotFound())
        ;
    }
}