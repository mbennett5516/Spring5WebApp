package com.bennett.javapractice.springguru.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.bennett.javapractice.springguru.spring5webapp.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long>{

}
