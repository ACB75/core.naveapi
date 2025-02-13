package com.w2m.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.w2m.entity.NaveEspacial;
import com.w2m.repository.GenericCrudRepository;
import com.w2m.repository.NaveEspacialRepository;
import com.w2m.service.NaveEspacialService;

@Service
public class NaveEspacialServiceImpl implements NaveEspacialService {

    @Autowired
    private NaveEspacialRepository repository;

    @Autowired 
    private GenericCrudRepository genericRepository;

    @Override
    public Page<NaveEspacial> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Optional<NaveEspacial> findById(Long id) {
        return genericRepository.findById(id);
    }

    @Override
    public List<NaveEspacial> findByNameContaining(String name) {
        return (List<NaveEspacial>) repository.findByNameContaining(name);
    }

    @Override
    public NaveEspacial save(NaveEspacial NaveEspacial) {
        return repository.save(NaveEspacial);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
