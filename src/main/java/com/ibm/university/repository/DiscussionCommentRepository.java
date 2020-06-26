package com.ibm.university.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ibm.university.entity.Comments;



public interface DiscussionCommentRepository extends MongoRepository<Comments, String> {

	List<Comments> findByIdIn(List<String> commentIds);

	List<Comments> findByDiscussionId(String discussionId);

}