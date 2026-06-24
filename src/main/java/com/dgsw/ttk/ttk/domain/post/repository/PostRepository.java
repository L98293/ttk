package com.dgsw.ttk.ttk.domain.post.repository;

import com.dgsw.ttk.ttk.domain.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PostRepository extends JpaRepository<Post, String> {

    Optional<Post> findPostById(UUID id);
}