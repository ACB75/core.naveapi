package com.core.naveapi.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.core.naveapi.model.NaveEspacial;
import com.core.naveapi.repository.NaveEspacialRepository;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class NaveServiceTest {

    @Mock
    private NaveEspacialRepository repository;

    @InjectMocks
    private NaveEspacialService service;

    @Test
    void getNaveEspacialById_shouldReturnNaveEspacial_whenIdExists() {
        NaveEspacial naveEspacial = new NaveEspacial();
        naveEspacial.setId(1L);
        naveEspacial.setName("X-Wing");

        when(repository.findById(1L)).thenReturn(Optional.of(naveEspacial));

        NaveEspacial result = service.findById(1L);

        assertNotNull(result);
        assertEquals("X-Wing", result.getName());
        verify(repository, times(1)).findById(1L);
    }
}
