package org.ijb.stock.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tb_produto_outlet")
@Data
public class OutletProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    @JoinColumn(name = "id_doacao")
    private Donation donation;
    @Column(name = "nm_produto_outlet")
    private String name;
    @Column(name = "ds_produto_outlet")
    private String description;

    public OutletProduct() {}

    public OutletProduct(Donation donation, String name, String description) {
        this.donation = donation;
        this.name = name;
        this.description = description;
    }
}
