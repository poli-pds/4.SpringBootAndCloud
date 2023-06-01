package co.edu.poli.productservice.service;

import co.edu.poli.productservice.persistence.entity.Category;
import co.edu.poli.productservice.persistence.entity.Product;

import java.util.List;

public interface ProductServices {

    void save(Product product);
    void delete(Product product);
    List<Product> findAll();
    Product findById(Long id);
    List<Product> findByCategory(Category category);
}

