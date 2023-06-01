package co.edu.poli.customerservice.persistence.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;


import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @NotEmpty(message = "El nit/numero no puede ser vacio")
    @Column(name = "number_id", unique = true,nullable = true)
    private String numberID;
    @NotEmpty(message = "El nombre no puede ser vacio")
    @Column(name = "name")
    private String name;
    @Email(message = "No es una direccion de email valida")
    @Column(name = "email")
    private String email;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}