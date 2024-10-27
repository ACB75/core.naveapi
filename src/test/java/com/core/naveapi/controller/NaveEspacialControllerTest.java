package com.core.naveapi.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import com.core.naveapi.model.NaveEspacial;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class NaveEspacialControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void testCrearNave() throws Exception {
		NaveEspacial nave = new NaveEspacial();
		nave.setName("X-Wing");
		nave.setSeries("Star Wars");

		mockMvc.perform(post("/api/naves").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(nave))).andExpect(status().isCreated())
				.andExpect(jsonPath("$.nombre").value("Millennium Falcon"));
	}

	@Test
	void testObtenerNavePorId() throws Exception {
		mockMvc.perform(get("/api/naves/{id}", 1)).andExpect(status().isOk())
				.andExpect(jsonPath("$.nombre").value("X-Wing"));
	}

	@Test
	void testBuscarPorNombre() throws Exception {
		mockMvc.perform(get("/api/naves/buscar?nombre=wing")).andExpect(status().isOk())
				.andExpect(jsonPath("$[0].nombre").value("X-Wing"));
	}
}
