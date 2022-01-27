package md.test.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "Product")
public class Product {
    @Id
    @Column(unique = true, nullable = false)
    private String product_id;
    private String product_name;
    private String manufacturer_id;

    public Product() {
    }

    public Product(String product_name, String manufacturer_id) {
        this.product_name = product_name;
        this.manufacturer_id = manufacturer_id;
    }
}