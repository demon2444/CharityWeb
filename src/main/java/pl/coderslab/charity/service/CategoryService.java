package pl.coderslab.charity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.model.Category;
import pl.coderslab.charity.repository.CategoryRepository;

import java.util.List;

@Service
@Transactional
public class CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    public Category findCategoryById(Long id) {
        return categoryRepository.findFirstById(id);
    }

    public Category findCategoryByName(String name) {
        return categoryRepository.findByName(name);
    }

    public List<Category> findAllcategories() {
        return categoryRepository.findAll();
    }

}
