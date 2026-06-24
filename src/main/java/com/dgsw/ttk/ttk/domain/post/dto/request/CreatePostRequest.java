package com.dgsw.ttk.ttk.domain.post.dto.request;

import com.dgsw.ttk.ttk.domain.post.entity.Post;
import com.dgsw.ttk.ttk.domain.post.entity.Status;

import java.util.UUID;

public record CreatePostRequest(

		String studentId,
		String studentName,
		String issue
) {

	public Post toEntity(CreatePostRequest createPostRequest) {

		return Post.builder()
				.id(null)
				.studentId(createPostRequest.studentId)
				.studentName(createPostRequest.studentName)
				.issue(createPostRequest.issue)
				.status(Status.WAIT)
				.build();
	}
}