package com.odr.newsoft.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.odr.newsoft.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, Integer> {

}
