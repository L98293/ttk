package com.dgsw.ttk.ttk.domain.post.repository;

import com.dgsw.ttk.ttk.domain.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, String> {
}