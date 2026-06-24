package com.dgsw.ttk.ttk.domain.post.service;

import com.dgsw.ttk.ttk.domain.post.dto.request.CreatePostRequest;
import com.dgsw.ttk.ttk.domain.post.dto.response.CreatePostResponse;
import com.dgsw.ttk.ttk.domain.post.repository.PostRepository;
import com.dgsw.ttk.ttk.domain.post.service.usecase.CreatePost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService implements CreatePost {

	@Autowired
	private PostRepository postRepository;

	@Override
	public CreatePostResponse createPost(CreatePostRequest createPostRequest) {

		postRepository.save(createPostRequest.toEntity(createPostRequest));

		return CreatePostResponse.of("제출되었습니다.");
	}
}
