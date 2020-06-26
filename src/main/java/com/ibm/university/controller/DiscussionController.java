package com.ibm.university.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.university.entity.Comments;
import com.ibm.university.entity.Discussion;
import com.ibm.university.entity.DiscussionDTO;
import com.ibm.university.service.DiscussionServiceImpl;

 
@RestController
@RequestMapping("/discussions")
public class DiscussionController {

	@Autowired
	private DiscussionServiceImpl discussionServiceImpl;
	
	@PostMapping("/new")
	public Discussion addNewDiscussion(@RequestBody Discussion discussion) {
		return this.discussionServiceImpl.saveDiscussion(discussion);
	}

	@GetMapping("/getall")
	public List<Discussion> getAllDiscussions() {
		return discussionServiceImpl.getAllDiscussion();
	}

	@GetMapping("/getbyId/{id}")
	public DiscussionDTO getDiscussionbyId(@PathVariable String id) {
		return discussionServiceImpl.getDiscussionbyId(id);
	}
	
	@GetMapping("/getbyauthorsname/{authorName}")
	public List<Discussion> getDiscussionByNameblog(@PathVariable String authorName) {
		return discussionServiceImpl.getDiscussionbyAuthorName(authorName);
	}

	@PostMapping("/addcomment")
	public  Comments addDiscussionComment(@RequestBody Comments  comments) {
		return this.discussionServiceImpl.saveDiscussionComment(comments);
	}
}
