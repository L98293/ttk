package com.dgsw.ttk.ttk.domain.post.controller;

import com.dgsw.ttk.ttk.domain.post.dto.request.CreatePostRequest;
import com.dgsw.ttk.ttk.domain.post.dto.response.CreatePostResponse;
import com.dgsw.ttk.ttk.domain.post.service.usecase.CreatePost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PostController {

    @Autowired
    private CreatePost createPost;

    @PostMapping("/post")
    public ResponseEntity<CreatePostResponse> createPost(CreatePostRequest createPostRequest) {

        return ResponseEntity.ok(createPost.createPost(createPostRequest));
    }
}