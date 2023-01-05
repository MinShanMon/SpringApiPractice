package sg.nus.iss.apiDarryl.apiDarryl.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import sg.nus.iss.apiDarryl.apiDarryl.Exception.ResourceNotFoundException;
import sg.nus.iss.apiDarryl.apiDarryl.Model.Comment;
import sg.nus.iss.apiDarryl.apiDarryl.service.CommentService;

@Tag(description = "Comment resources that provides access to available post data", name = "Comment Resource")
@RestController
@RequestMapping("/api")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping("/posts/{postId}/comments")
    public Page<Comment> getAllCommentsByPostId(@PathVariable(value = "postId") Long postId, Pageable pageable){
        return commentService.getAllCommentsByPostId(postId, pageable);
    }

    @PostMapping("/posts/{postId}/comments")
    public Comment createComment(@PathVariable(value = "postId") Long postId, @Valid @RequestBody Comment commetn){
        return commentService.saveComment(postId, commetn);
    }

    @PutMapping("/posts/{postId}/comments/{commentId}")
    public Comment updaComment(@PathVariable(value = "postId") Long postId, 
        @PathVariable(value = "commentId") Long commentId,
        @Valid @RequestBody Comment commentRequest){
        return commentService.updateComment(postId, commentId, commentRequest);
    }

    // @DeleteMapping("/posts/{postId}/comments/{commentId}")
    // public ResponseEntity<?> deleteComment(@PathVariable(value = "postId") Long postId,
    //     @PathVariable(value = "commentId") Long commentId){
    //     Boolean isDeleted = commentService.deleteComment(postId, commentId);

    //     if(isDeleted){
    //         return ResponseEntity.ok().build();
    //     }
    //     else{
    //         throw new ResourceNotFoundException("Comment not found with id " + commentId + " and postId" + postId);
    //     }
    // }

    @DeleteMapping("/posts/{postId}/comments/{commentId}")
    public ResponseEntity<Long> deleteComment(@PathVariable(value = "postId") Long postId,
        @PathVariable(value = "commentId") Long commentId){
        try{
            Boolean isDeleted = commentService.deleteComment(postId, commentId);

            if(!isDeleted){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(commentId, HttpStatus.OK );
        }
        catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
