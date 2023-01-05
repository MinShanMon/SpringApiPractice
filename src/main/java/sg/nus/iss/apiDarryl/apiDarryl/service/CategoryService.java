package sg.nus.iss.apiDarryl.apiDarryl.service;

import java.util.List;

import sg.nus.iss.apiDarryl.apiDarryl.Model.Category;

public interface CategoryService {

    Category saveCategory(Category category);

    List<Category> getCategoryList();
    
    Category updCategory(Category category, Long categoryId);

    Boolean deleteCategoryById(Long categoryId);
}
