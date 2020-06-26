package com.ibm.university.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ibm.university.entity.Discussion;


public interface DiscussionRepository extends MongoRepository<Discussion, String> {

	Discussion findByDiscussionTitle(String discussionTitle);

	List<Discussion> findByDiscussionAuthor(String discussionAuthor);
}