package com.udacity.pricing.repository;

import com.udacity.pricing.microservices.entity.Price;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends CrudRepository<Price, Long> {
}
