package sg.nus.iss.apiDarryl.apiDarryl.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;

import sg.nus.iss.apiDarryl.apiDarryl.Exception.ResourceNotFoundException;
import sg.nus.iss.apiDarryl.apiDarryl.Model.Comment;
import sg.nus.iss.apiDarryl.apiDarryl.repository.CommentRepository;
import sg.nus.iss.apiDarryl.apiDarryl.repository.PostRepository;

@Service
public class CommentServiceImpl implements CommentService{
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public Comment saveComment(Long postId, Comment comment) {
        //get post with postId and create new comment, and then set the post object into comment=> post object
        return postRepository.findById(postId).map(post->{
            comment.setPost(post);
            return commentRepository.save(comment);
        }).orElseThrow(()-> new ResourceNotFoundException("PostId "+ postId+ " not found"));
    }

    @Override
    public Comment updateComment(Long postId, Long commentId, Comment commentRequest) {
        //no post throw error
        if(!postRepository.existsById(postId)){
            throw new ResourceNotFoundException("PostId " + postId + " not found");
        }

        //get the comment with comment id and then, post the requested comment to existing comment
          return commentRepository.findById(commentId).map(comment -> {
            comment.setText(commentRequest.getText());
            return commentRepository.save(comment);
        }).orElseThrow(() -> new ResourceNotFoundException("CommentId " + commentId + "not found"));
    }

    @Override
    public Boolean deleteComment(Long postId, Long commentId) {
        //find comment with commendId and PostId and then, delete the commet 
        return commentRepository.findByIdAndPost(commentId, postId).map(comment->{
            commentRepository.delete(comment);
            return true;
        }).orElseThrow(()->new ResourceNotFoundException("Comment not found with id " + commentId + " and postId" + postId));
    }

    @Override
    public Page<Comment> getAllCommentsByPostId(Long postId, Pageable pageable) {
        return commentRepository.findByPostId(postId, pageable);
    }
}
