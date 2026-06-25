package com.dgsw.ttk.ttk.domain.post.dto.response;

public record UpdatePostResponse(
		String message
) {

	public static UpdatePostResponse of(String message) {

		return new UpdatePostResponse(message);
	}
}
