package com.diamante.springframeworkguru.repository;

import com.diamante.springframeworkguru.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
