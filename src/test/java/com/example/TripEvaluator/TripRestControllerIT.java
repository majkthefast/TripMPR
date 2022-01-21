package com.example.TripEvaluator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TripRestControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnExampleTrip() throws Exception{
        mockMvc.perform(get("/trip/example"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("{\"id\":1,\"title\":\"Wakacje\",\"destination\":\"BaÅ\u0082yk\",\"cena\":1000,\"reviews\":[{\"id\":1,\"content\":\"content\",\"rating\":5,\"opinion\":\"POSITIVE\",\"author\":[{\"id\":1,\"name\":\"Krzysztof\",\"surname\":\"Szymczyk\",\"age\":20}]}]}"));
    }
}
