package com.ibm.university.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.university.entity.BlogComment;
import com.ibm.university.entity.BlogDTO;
import com.ibm.university.entity.BlogDetails;
import com.ibm.university.repository.BlogRepository;
import com.ibm.university.repository.CommentRepository;

 

@Service
public class BlogService {

	@Autowired
	BlogRepository blogRepository;

	@Autowired
	CommentRepository commentRepository;

	public List<BlogDetails> getAllblogs() {
		return blogRepository.findAll();
	}

	public BlogDetails updateBlog(BlogDetails blogDetails) {
		Optional<BlogDetails> optionalblogDetails = blogRepository.findById(blogDetails.getBlogId());
		BlogDetails bd = null;
		if (optionalblogDetails.isPresent()) {
			bd = optionalblogDetails.get();
			bd.setBlogTitle(blogDetails.getBlogTitle());
			bd.setBody(blogDetails.getBody());
		}

		return this.blogRepository.save(bd);
	}

	public BlogDetails saveBlog(BlogDetails blogDetails) {
		return this.blogRepository.save(blogDetails);

	}

	public List<BlogDetails> getBlogbyAuthorName(String authorName) {
		return blogRepository.findByBlogAuthor(authorName);
	}

	public BlogDTO getBlogbyId(String id) {
		BlogDetails blog = blogRepository.findById(id).orElse(null);
		List<BlogComment> comments = commentRepository.findByBlogId(blog.getBlogId());
		BlogDTO blogdto = new BlogDTO(blog.getBlogId(), blog.getBlogTitle(), blog.getBlogAuthor(), blog.getBody(),
				comments);
		return blogdto;
	}
	
	public BlogComment saveComment(BlogComment comments) {
		return commentRepository.save(comments);
	}
}
