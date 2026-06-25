package com.dgsw.ttk.ttk.domain.post.service.usecase;

import com.dgsw.ttk.ttk.domain.post.dto.request.UpdatePostRequest;
import com.dgsw.ttk.ttk.domain.post.dto.response.UpdatePostResponse;

public interface UpdatePost {

	UpdatePostResponse approvePost(UpdatePostRequest updatePostRequest);
	UpdatePostResponse rejectPost(UpdatePostRequest updatePostRequest);
}
