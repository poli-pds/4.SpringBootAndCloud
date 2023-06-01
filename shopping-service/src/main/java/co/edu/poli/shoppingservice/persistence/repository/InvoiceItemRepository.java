package co.edu.poli.shoppingservice.persistence.repository;


import co.edu.poli.shoppingservice.persistence.entity.InvoiceItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceItemRepository extends JpaRepository<InvoiceItem,Long> {
}
