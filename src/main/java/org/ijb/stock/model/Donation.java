package org.ijb.stock.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tb_doacao")
@Data
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_doador")
    private Donor donor;
    @Column(name = "ds_doacao")
    private String description;
    @Column(name = "qt_doacao")
    private Long quantity;

    public Donation() {
    }

    public Donation(Donor donor, String description, Long quantity) {
        this.donor = donor;
        this.description = description;
        this.quantity = quantity;
    }
}
