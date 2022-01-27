package md.test.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Manufacturer")
public class Manufacturer {
    @Id
    @Column(unique = true, nullable = false)
    private String manufacturer_id;
    private String manufacturer_name;

    public Manufacturer() {
    }

    public Manufacturer(String manufacturer_id, String manufacturer_name) {
        this.manufacturer_id = manufacturer_id;
        this.manufacturer_name = manufacturer_name;
    }
}