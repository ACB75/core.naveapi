package com.w2m.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.w2m.entity.NaveEspacial;

@Service
public interface NaveEspacialService {

    public Page<NaveEspacial> findAll(Pageable pageable);

    public Optional<NaveEspacial> findById(Long id);

    public List<NaveEspacial> findByNameContaining(String name);

    public NaveEspacial save(NaveEspacial NaveEspacial);

    public void deleteById(Long id);
}