package co.edu.poli.productservice.persistence.repository;

import co.edu.poli.productservice.persistence.entity.Category;
import co.edu.poli.productservice.persistence.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product> findByCategory(Category category);
}
