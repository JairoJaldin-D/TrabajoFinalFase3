package eccomerce.tp.controllers;

import eccomerce.tp.entities.Category;
import eccomerce.tp.services.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {
    Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    private CategoryService categoryService;


    @PostMapping("/categories")
    public Category newCategory(@RequestBody Category category) {

        Category saved = categoryService.saveCategory(category);

        logger.info("Creando categoria nueva: "+ saved);

        return saved;
    }

    @GetMapping("/categories")
    public List<Category> getCategories() {

        List<Category> categories = categoryService.getAll();
        logger.info("Categories: " + categories);

        return categories;
    }

    @GetMapping("/categories/{categoryId}")
    public Category getCategoryById(@PathVariable(name = "categoryId") Long categoryId) {

        Category category = categoryService.getCategoryById(categoryId);
        logger.info("Category: " + category);

        return category;
    }


}
