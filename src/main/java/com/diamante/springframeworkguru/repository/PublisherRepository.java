package com.diamante.springframeworkguru.repository;

import com.diamante.springframeworkguru.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
