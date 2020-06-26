package com.ibm.university.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "discussion")
public class Discussion {
	@Id
	private String discussionId;
	private String discussionTitle;
	private String discussionAuthor;
	private String body;

	public String getDiscussionId() {
		return discussionId;
	}

	public void setDiscussionId(String discussionId) {
		this.discussionId = discussionId;
	}

	public String getDiscussionTitle() {
		return discussionTitle;
	}

	public void setDiscussionTitle(String discussionTitle) {
		this.discussionTitle = discussionTitle;
	}

	public String getDiscussionAuthor() {
		return discussionAuthor;
	}

	public void setDiscussionAuthor(String discussionAuthor) {
		this.discussionAuthor = discussionAuthor;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

}
