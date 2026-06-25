package com.dgsw.ttk.ttk.domain.post.service.usecase;

import com.dgsw.ttk.ttk.domain.post.entity.Post;

import java.util.List;
import java.util.UUID;

public interface ViewPost {

    Post viewPost(UUID uuid);

    List<Post> viewAllPost();
}