package co.edu.poli.productservice.service;

import co.edu.poli.productservice.persistence.entity.Category;

import java.util.List;

public interface CategoryServices {
    void save(Category category);
    List<Category> findAll();
}
