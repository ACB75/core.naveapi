package com.w2m.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.w2m.entity.NaveEspacial;

public interface NaveEspacialRepository extends JpaRepository<NaveEspacial, Long> {

    List<NaveEspacial> findByNameContaining(String name);
}
