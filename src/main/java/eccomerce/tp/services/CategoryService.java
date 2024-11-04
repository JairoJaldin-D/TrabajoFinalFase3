package eccomerce.tp.services;

import eccomerce.tp.entities.Category;

import java.util.List;

public interface CategoryService {

    Category saveCategory(Category category);

    List<Category> getAll();

    Category getCategoryById(Long id);


}
