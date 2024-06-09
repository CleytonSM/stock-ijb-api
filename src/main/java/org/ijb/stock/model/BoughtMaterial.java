package org.ijb.stock.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_material_comprado")
public class BoughtMaterial extends Material{

    @Column(name = "priceBought")
    private Float priceBought;

    public BoughtMaterial() {
    }

    public BoughtMaterial(Float priceBought) {
        this.priceBought = priceBought;
    }

    public BoughtMaterial(Long quantity, String name, Float priceBought) {
        super(quantity, name);
        this.priceBought = priceBought;
    }
}
