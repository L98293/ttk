package com.dgsw.ttk.ttk.domain.post.controller;

import com.dgsw.ttk.ttk.domain.post.dto.request.CreatePostRequest;
import com.dgsw.ttk.ttk.domain.post.dto.response.CreatePostResponse;
import com.dgsw.ttk.ttk.domain.post.entity.Post;
import com.dgsw.ttk.ttk.domain.post.service.usecase.CreatePost;
import com.dgsw.ttk.ttk.domain.post.service.usecase.ViewPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class PostController {

    @Autowired
    private CreatePost createPost;

    @Autowired
    private ViewPost viewPost;

    @PostMapping("/post")
    public ResponseEntity<CreatePostResponse> createPost(@RequestBody CreatePostRequest createPostRequest) {

        return ResponseEntity.ok(createPost.createPost(createPostRequest));
    }

    @GetMapping("/post/{uuid}")
    public ResponseEntity<Post> viewPost(@PathVariable UUID uuid) {

        return ResponseEntity.ok(viewPost.viewPost(uuid));
    }

    @GetMapping("/post")
    public ResponseEntity<List<Post>> viewAllPost() {

        return ResponseEntity.ok(viewPost.viewAllPost());
    }
}