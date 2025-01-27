package com.w2m.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.w2m.NavesApplication;
import com.w2m.entity.NaveEspacial;

@SpringBootTest(classes = NavesApplication.class)
class NaveEspacialServiceTest {

    @Autowired
    private NaveEspacialService service;

    @Test
    void testFindById() {
        NaveEspacial naveEspacial = new NaveEspacial();
        naveEspacial.setName("X-Wing");
        naveEspacial.setSeries("Star Wars");
        service.save(naveEspacial);

        Optional<NaveEspacial> found;
        found = service.findById(naveEspacial.getId());
        assertTrue(found.isPresent());
        assertEquals("X-Wing", found.get().getName());
    }
}
