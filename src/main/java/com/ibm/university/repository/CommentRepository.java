package com.ibm.university.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ibm.university.entity.BlogComment;


@Repository
public interface CommentRepository extends MongoRepository<BlogComment, String> {

	List<BlogComment> findByIdIn(List<String> commentIds);
	List<BlogComment> findByBlogId(String blogId);

}