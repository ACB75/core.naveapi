package com.w2m.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.w2m.entity.NaveEspacial;

public interface NaveEspacialRepository extends JpaRepository<NaveEspacial, Long> {

    Page<NaveEspacial> findByNameContaining(String name, Pageable pageable);
}
