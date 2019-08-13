package app.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//Тест контроллера
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HttpRequestTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testHTTPStatus() throws Exception {
        this.mockMvc
                .perform(get("/code/Ukraine"))
                .andDo(print())
                .andExpect(status().isOk())
        ;

        this.mockMvc
                .perform(get("/code/Poland"))
                .andDo(print())
                .andExpect(status().isOk())
        ;
        this.mockMvc
                .perform(get("/code/Russia"))
                .andDo(print())
                .andExpect(status().isOk())
        ;
        this.mockMvc
                .perform(post("/reload"))
                .andDo(print())
                .andExpect(status().isOk())
        ;
    }
}