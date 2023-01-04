package sg.nus.iss.apiDarryl.apiDarryl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sg.nus.iss.apiDarryl.apiDarryl.Model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    
}
