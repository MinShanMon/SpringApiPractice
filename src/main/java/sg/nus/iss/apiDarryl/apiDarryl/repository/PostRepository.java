package sg.nus.iss.apiDarryl.apiDarryl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.nus.iss.apiDarryl.apiDarryl.Model.Post;

public interface PostRepository extends JpaRepository<Post, Long>{
    
}
