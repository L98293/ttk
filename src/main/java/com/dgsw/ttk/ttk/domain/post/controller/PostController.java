package com.dgsw.ttk.ttk.domain.post.controller;

import com.dgsw.ttk.ttk.domain.post.dto.request.CreatePostRequest;
import com.dgsw.ttk.ttk.domain.post.dto.request.UpdatePostRequest;
import com.dgsw.ttk.ttk.domain.post.dto.response.CreatePostResponse;
import com.dgsw.ttk.ttk.domain.post.dto.response.DeletePostResponse;
import com.dgsw.ttk.ttk.domain.post.dto.response.UpdatePostResponse;
import com.dgsw.ttk.ttk.domain.post.entity.Post;
import com.dgsw.ttk.ttk.domain.post.service.usecase.CreatePost;
import com.dgsw.ttk.ttk.domain.post.service.usecase.DeletePost;
import com.dgsw.ttk.ttk.domain.post.service.usecase.UpdatePost;
import com.dgsw.ttk.ttk.domain.post.service.usecase.ViewPost;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/post")
public class PostController {

    private final CreatePost createPost;
    private final ViewPost viewPost;
    private final UpdatePost updatePost;
    private final DeletePost deletePost;

    @PostMapping
    public ResponseEntity<CreatePostResponse> createPost(@RequestBody CreatePostRequest createPostRequest) {

        return ResponseEntity.ok(createPost.createPost(createPostRequest));
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<Post> viewPost(@PathVariable UUID uuid) {

        return ResponseEntity.ok(viewPost.viewPost(uuid));
    }

    @GetMapping
    public ResponseEntity<List<Post>> viewAllPost() {

        return ResponseEntity.ok(viewPost.viewAllPost());
    }

    @PatchMapping("/approve")
    public ResponseEntity<UpdatePostResponse> approvePost(@RequestBody UpdatePostRequest updatePostRequest) {

        return ResponseEntity.ok(updatePost.approvePost(updatePostRequest));
    }

    @PatchMapping("/reject")
    public ResponseEntity<UpdatePostResponse> rejectPost(@RequestBody UpdatePostRequest updatePostRequest) {

        return ResponseEntity.ok(updatePost.rejectPost(updatePostRequest));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<DeletePostResponse> deletePost(@RequestParam UUID uuid) {

        return ResponseEntity.ok(deletePost.deletePost(uuid));
    }
}