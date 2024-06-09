package org.ijb.stock.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tb_material")
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public class Material {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    @Column(name = "nm_material")
    private String name;
    @Column(name = "qt_material")
    private Long quantity;

    public Material() {
    }

    public Material(Long quantity, String name) {
        this.quantity = quantity;
        this.name = name;
    }
}
