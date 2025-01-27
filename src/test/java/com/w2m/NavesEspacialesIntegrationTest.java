package com.w2m;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

@SpringBootTest
@AutoConfigureMockMvc
class NavesEspacialesIntegrationTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    void getSpaceshipsTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/navesespaciales")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    
    @Test
    void getSpaceshipByIdTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/navesespaciales/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    
    @Test
    void createSpaceshipTest() throws Exception {
        String newSpaceship = "{\"name\":\"Falcon\",\"type\":\"Cargo\"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/api/navesespaciales")
                .contentType(MediaType.APPLICATION_JSON)
                .content(newSpaceship))
                .andExpect(status().isCreated());
    }
}
