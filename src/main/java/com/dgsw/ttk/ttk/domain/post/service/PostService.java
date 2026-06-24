package com.dgsw.ttk.ttk.domain.post.service;

import com.dgsw.ttk.ttk.domain.post.dto.request.CreatePostRequest;
import com.dgsw.ttk.ttk.domain.post.dto.response.CreatePostResponse;
import com.dgsw.ttk.ttk.domain.post.entity.Post;
import com.dgsw.ttk.ttk.domain.post.repository.PostRepository;
import com.dgsw.ttk.ttk.domain.post.service.usecase.CreatePost;
import com.dgsw.ttk.ttk.domain.post.service.usecase.ViewPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class PostService implements CreatePost, ViewPost {
    @Autowired
    private PostRepository postRepository;

    @Override
    public CreatePostResponse createPost(CreatePostRequest createPostRequest) {

        postRepository.save(createPostRequest.toEntity(createPostRequest));

        return CreatePostResponse.of("제출되었습니다.");
    }

    @Override
    public Post viewPost(UUID uuid) {

        return postRepository.findPostById(uuid).orElseThrow(() -> new RuntimeException("존재하지 않는 게시물 입니다."));
    }

    @Override
    public List<Post> viewAllPost() {

        return postRepository.findAll();
    }
}
