package com.ibm.university.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ibm.university.entity.User;

 
public interface UserRepository extends MongoRepository<User, String> {

	User findByUsername(String username);

}