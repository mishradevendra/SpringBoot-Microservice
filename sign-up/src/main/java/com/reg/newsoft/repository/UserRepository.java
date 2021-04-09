package com.reg.newsoft.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.reg.newsoft.model.User;

public interface UserRepository extends MongoRepository<User, Integer> {

	User findByUserId(Integer id);

}
