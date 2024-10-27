package com.core.naveapi.controller;

import com.core.naveapi.model.NaveEspacial;
import com.core.naveapi.service.NaveEspacialService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/naves")
public class NaveEspacialController {

	@Autowired
	private NaveEspacialService service;

	@GetMapping
	public ResponseEntity<Page<NaveEspacial>> getAllNaveEspacials(Pageable pageable) {
		return ResponseEntity.ok(service.findAll(pageable));
	}

	@GetMapping("/{id}")
	public ResponseEntity<NaveEspacial> getNaveEspacialById(@PathVariable Long id) {
		return ResponseEntity.ok(service.findById(id));
	}

	@GetMapping("/search")
	public ResponseEntity<Page<NaveEspacial>> getNaveEspacialsByName(@RequestParam String name, Pageable pageable) {
		return ResponseEntity.ok(service.findByName(name, pageable));
	}

	@PostMapping
	public ResponseEntity<NaveEspacial> create(@RequestBody NaveEspacial NaveEspacial) {
		return ResponseEntity.ok(service.save(NaveEspacial));
	}

	@PutMapping("/{id}")
	public ResponseEntity<NaveEspacial> update(@PathVariable Long id, @RequestBody NaveEspacial NaveEspacial) {
		return ResponseEntity.ok(service.update(id, NaveEspacial));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteNaveEspacial(@PathVariable Long id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
