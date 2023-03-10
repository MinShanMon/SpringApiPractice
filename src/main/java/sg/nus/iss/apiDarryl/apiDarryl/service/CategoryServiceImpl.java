package sg.nus.iss.apiDarryl.apiDarryl.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.nus.iss.apiDarryl.apiDarryl.Model.Category;
import sg.nus.iss.apiDarryl.apiDarryl.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository repo){
        this.categoryRepository = repo;
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getCategoryList() {
        return categoryRepository.findAll();
    }

    @Override
    public Category updCategory(Category category, Long categoryId) {
        Category  categoryEnt = categoryRepository.findById(categoryId).get();

        if(Objects.nonNull(category.getName()) && !"".equalsIgnoreCase(category.getName())){
            categoryEnt.setName(category.getName());
        }
        return categoryRepository.save(categoryEnt);
    }


    @Override
    public Boolean deleteCategoryById(Long categoryId) {
        try{
            categoryRepository.deleteById(categoryId);
            return true;
        }
        catch(Exception e){
            return false;
        }
        
    }
    
}
