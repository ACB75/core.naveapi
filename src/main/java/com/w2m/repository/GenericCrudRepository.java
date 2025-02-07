package com.w2m.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenericCrudRepository<T, ID> extends CrudRepository<T, ID> {}