package sg.nus.iss.apiDarryl.apiDarryl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.nus.iss.apiDarryl.apiDarryl.Model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    
}
