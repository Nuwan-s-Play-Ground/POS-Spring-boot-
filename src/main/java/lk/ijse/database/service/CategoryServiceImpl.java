package lk.ijse.database.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lk.ijse.database.entity.Category;
import lk.ijse.database.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{
    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAllCategories() {
       return categoryRepository.findAll();
    }

   
    @Override
    public Category getCategoryById(Long id) {
       return categoryRepository.findById(id).orElseThrow(()->new NoSuchElementException("Category not found"+id));
    }

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Long id, Category category) {
     
        Category existingCategory=getCategoryById(id);

        existingCategory.setName(category.getName());
       // existingCategory.setId(category.getId());

        return categoryRepository.save(existingCategory);
    }

    @Override
    public void deleteCategory(Long id) {
       categoryRepository.deleteById(id);
    }
    
}
