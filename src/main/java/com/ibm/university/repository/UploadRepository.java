package com.ibm.university.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ibm.university.entity.Photo;


public interface UploadRepository extends MongoRepository<Photo, String> {
}

