package com.w2m.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.w2m.entity.NaveEspacial;
import com.w2m.service.NaveEspacialService;

@RestController
@RequestMapping("/api/navesepacial")
public class NaveEspacialController {

        @Autowired
        private NaveEspacialService service;
    
        @GetMapping
        public Page<NaveEspacial> getAllNaveEspacials(Pageable pageable) {
            return service.findAll(pageable);
        }
    
        @GetMapping("/{id}")
        public ResponseEntity<NaveEspacial> getNaveEspacialById(@PathVariable Long id) {
            return service.findById(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        }
    
        @GetMapping("/search")
        public Page<NaveEspacial> searchNaveEspacials(@RequestParam String name, Pageable pageable) {
            return service.findByNameContaining(name, pageable);
        }
    
        @PostMapping
        public NaveEspacial createNaveEspacial(@RequestBody NaveEspacial NaveEspacial) {
            return service.save(NaveEspacial);
        }
    
        @PutMapping("/{id}")
        public ResponseEntity<NaveEspacial> updateNaveEspacial(@PathVariable Long id, @RequestBody NaveEspacial NaveEspacial) {
            if (service.findById(id).isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            NaveEspacial.setId(id);
            return ResponseEntity.ok(service.save(NaveEspacial));
        }
    
        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteNaveEspacial(@PathVariable Long id) {
            if (service.findById(id).isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            service.deleteById(id);
            return ResponseEntity.noContent().build();
        }
    }