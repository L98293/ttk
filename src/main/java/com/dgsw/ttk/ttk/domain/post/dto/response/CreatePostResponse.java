package com.dgsw.ttk.ttk.domain.post.dto.response;

public record CreatePostResponse(

		String message
) {

	public static CreatePostResponse of(String message) {

		return new CreatePostResponse(message);
	}
}
