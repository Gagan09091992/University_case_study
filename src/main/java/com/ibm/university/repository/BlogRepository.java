package com.ibm.university.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ibm.university.entity.BlogDetails;


public interface BlogRepository extends MongoRepository<BlogDetails, String> {

	BlogDetails findByBlogTitle(String blogTitle);
	
	List<BlogDetails> findByBlogAuthor(String blogAuthor);
}