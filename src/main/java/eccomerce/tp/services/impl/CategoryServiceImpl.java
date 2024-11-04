package eccomerce.tp.services.impl;

import eccomerce.tp.entities.Category;
import eccomerce.tp.exceptions.CategoryNotFoundException;
import eccomerce.tp.repositories.CategoryRepository;
import eccomerce.tp.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException("Categoria no encontrada"));
    }


}
