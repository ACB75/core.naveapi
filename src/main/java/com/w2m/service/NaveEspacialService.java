package com.w2m.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.w2m.entity.NaveEspacial;
import com.w2m.repository.NaveEspacialRepository;

@Service
public class NaveEspacialService {

    @Autowired
    private NaveEspacialRepository repository;

    public Page<NaveEspacial> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Optional<NaveEspacial> findById(Long id) {
        return repository.findById(id);
    }

    public Page<NaveEspacial> findByNameContaining(String name, Pageable pageable) {
        return repository.findByNameContaining(name, pageable);
    }

    public NaveEspacial save(NaveEspacial NaveEspacial) {
        return repository.save(NaveEspacial);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}