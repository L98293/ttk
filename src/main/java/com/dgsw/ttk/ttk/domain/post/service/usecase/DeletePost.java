package com.dgsw.ttk.ttk.domain.post.service.usecase;

import com.dgsw.ttk.ttk.domain.post.dto.response.DeletePostResponse;

import java.util.UUID;

public interface DeletePost {

	DeletePostResponse deletePost(UUID uuid);
}
