package com.apex.eqp.inventory.entities;

import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Getter
@Setter
@ToString
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(unique = true)
    @NotBlank(message = "Product name can not be blank")
    @Size(max=100,message = "Product name must not exceed 100 characters")
    String name;

    @NotNull
    @DecimalMin(value = "0.0",inclusive = true,message = "Price must be greater than or equal to 0")
    Double price;
    @NotNull
    Integer quantity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Product product = (Product) o;
        return id != null && Objects.equals(id, product.id);
    }
    //validation data for name price and quantity
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
