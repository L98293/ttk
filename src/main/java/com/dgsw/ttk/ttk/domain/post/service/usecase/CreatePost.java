package com.dgsw.ttk.ttk.domain.post.service.usecase;

import com.dgsw.ttk.ttk.domain.post.dto.request.CreatePostRequest;
import com.dgsw.ttk.ttk.domain.post.dto.response.CreatePostResponse;

public interface CreatePost {

    CreatePostResponse createPost(CreatePostRequest createPostRequest);
}