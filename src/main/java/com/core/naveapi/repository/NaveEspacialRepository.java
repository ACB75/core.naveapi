package com.core.naveapi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.core.naveapi.model.NaveEspacial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NaveEspacialRepository extends JpaRepository<NaveEspacial, Long> {

	Page<NaveEspacial> findByNameContainingIgnoreCase(String name, Pageable pageable);
}
