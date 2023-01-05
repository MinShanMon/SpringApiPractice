package sg.nus.iss.apiDarryl.apiDarryl.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import sg.nus.iss.apiDarryl.apiDarryl.Model.Post;

public interface PostService {
    Post savePost(Post post);
    
    Page<Post> getPostList(Pageable pageable);
    
    Post updatePost(Post post, Long postId);

    Boolean deletePostById(Long postId);
}
