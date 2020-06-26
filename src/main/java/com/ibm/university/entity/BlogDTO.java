package com.ibm.university.entity;

import java.util.List;

import org.springframework.data.annotation.Id;

public class BlogDTO {
	private String blogId;
	private String blogTitle;
	private String blogAuthor;
	private String body;
	private List<BlogComment> comments;

	public String getBlogId() {
		return blogId;
	}

	public void setBlogId(String blogId) {
		this.blogId = blogId;
	}

	public String getBlogTitle() {
		return blogTitle;
	}

	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}

	public String getBlogAuthor() {
		return blogAuthor;
	}

	public void setBlogAuthor(String blogAuthor) {
		this.blogAuthor = blogAuthor;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public List<BlogComment> getComments() {
		return comments;
	}

	public void setComments(List<BlogComment> comments) {
		this.comments = comments;
	}

	public BlogDTO(String blogId, String blogTitle, String blogAuthor, String body, List<BlogComment> comments2) {
		super();
		this.blogId = blogId;
		this.blogTitle = blogTitle;
		this.blogAuthor = blogAuthor;
		this.body = body;
		this.comments = comments2;
	}

}
