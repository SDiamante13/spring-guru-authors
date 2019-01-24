package com.diamante.springframeworkguru.repository;

import com.diamante.springframeworkguru.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
