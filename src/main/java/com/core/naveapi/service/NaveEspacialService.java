package com.core.naveapi.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.core.naveapi.broker.RabbitMQProducer;
import com.core.naveapi.model.NaveEspacial;
import com.core.naveapi.repository.NaveEspacialRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;

@Service
public class NaveEspacialService {

	private final NaveEspacialRepository repository;
	
	private final RabbitMQProducer rabbitMQProducer;

	public NaveEspacialService(NaveEspacialRepository repository, RabbitMQProducer rabbitMQProducer) {
		super();
		this.repository = repository;
		this.rabbitMQProducer = rabbitMQProducer;
	}

	public Page<NaveEspacial> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Cacheable(value = "naveEspacial", key = "#id")
	public NaveEspacial findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new RuntimeException("NaveEspacial not found"));
	}

	public Page<NaveEspacial> findByName(String name, Pageable pageable) {
		return repository.findByNameContainingIgnoreCase(name, pageable);
	}

	@CacheEvict(value = "naveEspacial", allEntries = true)
	public NaveEspacial save(NaveEspacial naveEspacial) {
		return repository.save(naveEspacial);
	}

	@CacheEvict(value = "naveEspacial", key = "#id")
	public NaveEspacial update(Long id, NaveEspacial naveEspacial) {
		NaveEspacial existingNaveEspacial = findById(id);
		existingNaveEspacial.setName(naveEspacial.getName());
		existingNaveEspacial.setSeries(naveEspacial.getSeries());
		return repository.save(existingNaveEspacial);
	}

	@CacheEvict(value = "naveEspacial", key = "#id")
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}
