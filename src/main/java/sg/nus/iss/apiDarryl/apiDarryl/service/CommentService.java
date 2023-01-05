package sg.nus.iss.apiDarryl.apiDarryl.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import sg.nus.iss.apiDarryl.apiDarryl.Model.Comment;

public interface CommentService {
    Page<Comment> getAllCommentsByPostId(Long postId, Pageable pageable);

    Comment saveComment(Long postId, Comment comment);

    Comment updateComment(Long postId, Long commentId, Comment commentRequest);

    Boolean deleteComment(Long postId, Long commentId);
}
