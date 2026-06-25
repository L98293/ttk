package com.dgsw.ttk.ttk.domain.post.dto.response;

public record DeletePostResponse(
		String message
) {

	public static DeletePostResponse of(String message) {

		return new DeletePostResponse(message);
	}
}
