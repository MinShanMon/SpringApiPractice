package sg.nus.iss.apiDarryl.apiDarryl.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sg.nus.iss.apiDarryl.apiDarryl.Model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>{
    Page<Comment> findByPostId(Long postId, Pageable pageable);
    Optional<Comment> findByIdAndPost(Long id, Long postId);
}
