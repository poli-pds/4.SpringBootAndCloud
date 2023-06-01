package co.edu.poli.customerservice.persistence.repository;


import co.edu.poli.customerservice.persistence.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Customer findByNumberID(String numberID);
}
