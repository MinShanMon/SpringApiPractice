package sg.nus.iss.apiDarryl.apiDarryl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.nus.iss.apiDarryl.apiDarryl.Model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>{
    
}
