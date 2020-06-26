package com.ibm.university.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.university.entity.Comments;
import com.ibm.university.entity.Discussion;
import com.ibm.university.entity.DiscussionDTO;
import com.ibm.university.repository.DiscussionCommentRepository;
import com.ibm.university.repository.DiscussionRepository;


@Service
public class DiscussionServiceImpl {

	@Autowired
	DiscussionRepository discussionRepository;

	@Autowired
	DiscussionCommentRepository discussionCommentRepository;

	public List<Discussion> getAllDiscussion() {
		return discussionRepository.findAll();
	}

	public Discussion saveDiscussion(Discussion discussion) {
		return this.discussionRepository.save(discussion);

	}

	public List<Discussion> getDiscussionbyAuthorName(String discussionAuthor) {
		return discussionRepository.findByDiscussionAuthor(discussionAuthor);
	}

	public DiscussionDTO getDiscussionbyId(String discussionId) {
		Discussion discussion = discussionRepository.findById(discussionId).orElse(null);
		List<Comments> comments = discussionCommentRepository.findByDiscussionId(discussion.getDiscussionId());
		DiscussionDTO discussionDTO = new DiscussionDTO(discussionId, discussion.getDiscussionTitle(),
				discussion.getDiscussionAuthor(), discussion.getBody(), comments);
		return discussionDTO;
	}

	public Comments saveDiscussionComment(Comments  comments) {
		return discussionCommentRepository.save(comments);
	}
}
