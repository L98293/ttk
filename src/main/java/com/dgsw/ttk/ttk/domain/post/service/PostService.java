package com.dgsw.ttk.ttk.domain.post.service;

import com.dgsw.ttk.ttk.domain.post.dto.request.CreatePostRequest;
import com.dgsw.ttk.ttk.domain.post.dto.request.UpdatePostRequest;
import com.dgsw.ttk.ttk.domain.post.dto.response.CreatePostResponse;
import com.dgsw.ttk.ttk.domain.post.dto.response.DeletePostResponse;
import com.dgsw.ttk.ttk.domain.post.dto.response.UpdatePostResponse;
import com.dgsw.ttk.ttk.domain.post.entity.Post;
import com.dgsw.ttk.ttk.domain.post.entity.Status;
import com.dgsw.ttk.ttk.domain.post.repository.PostRepository;
import com.dgsw.ttk.ttk.domain.post.service.usecase.CreatePost;
import com.dgsw.ttk.ttk.domain.post.service.usecase.DeletePost;
import com.dgsw.ttk.ttk.domain.post.service.usecase.UpdatePost;
import com.dgsw.ttk.ttk.domain.post.service.usecase.ViewPost;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class PostService implements
        CreatePost,
        ViewPost,
        UpdatePost,
        DeletePost
{

    private final PostRepository postRepository;

	@Override
    public CreatePostResponse createPost(CreatePostRequest createPostRequest) {

        postRepository.save(createPostRequest.toEntity(createPostRequest));

        return CreatePostResponse.of("제출되었습니다.");
    }

    @Override
    @Transactional(readOnly = true)
    public Post viewPost(UUID uuid) {

        return findPost(uuid);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Post> viewAllPost() {

        return postRepository.findAll();
    }

    @Override
    public UpdatePostResponse approvePost(UpdatePostRequest updatePostRequest) {


        findPost(updatePostRequest.uuid()).setStatus(Status.APPROVE);

        return UpdatePostResponse.of("승인되었습니다.");
    }

    @Override
    public UpdatePostResponse rejectPost(UpdatePostRequest updatePostRequest) {

        findPost(updatePostRequest.uuid()).setStatus(Status.REJECT);

        return UpdatePostResponse.of("거절되었습니다.");
    }

    @Override
    public DeletePostResponse deletePost(UUID uuid) {

        postRepository.delete(findPost(uuid));

        return DeletePostResponse.of("삭제되었습니다.");
    }

    private Post findPost(UUID uuid) {

        return postRepository.findPostById(uuid)
                .orElseThrow(
                        () -> new RuntimeException("존재하지 않는 게시물 입니다.")
                );
    }
}
