package com.ibm.university.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.university.entity.BlogComment;
import com.ibm.university.entity.BlogDTO;
import com.ibm.university.entity.BlogDetails;
import com.ibm.university.service.BlogService;



@RestController
@RequestMapping("/restservices/blog")
public class BlogController {
	

	@Autowired
	private BlogService blogService;
	
	@GetMapping("/getall")
	public List<BlogDetails> getAllBlogs() {
		return blogService.getAllblogs();
	}
	
	@PostMapping("/add")
	public BlogDetails addBlog(@RequestBody BlogDetails blogDetails) {
		return this.blogService.saveBlog(blogDetails);
	}
	
	
	@PutMapping("/update")
	public BlogDetails updateGroup(@RequestBody BlogDetails blogDetails) {
		return this.blogService.updateBlog(blogDetails);
	}
	
	@GetMapping("/getbyauthonamer/{authorName}")
	public List<BlogDetails> getGroupByNameblog(@PathVariable String authorName) {
		return blogService.getBlogbyAuthorName(authorName);
	}

	
	@GetMapping("/getbyId/{id}")
	public BlogDTO getBlogbyId(@PathVariable String id) {
		return blogService.getBlogbyId(id);
	}
	
	@PostMapping("/addcomment")
	public BlogComment addComment(@RequestBody BlogComment comment) {
		return this.blogService.saveComment(comment);
	}
}
