package org.ijb.stock.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "tb_material_doado")
@Data
public class DonatedMaterial extends Material{

    @Column(name = "dt_docao")
    private Date donationDate;

    public DonatedMaterial() {
    }

    public DonatedMaterial(Long quantity, String name, Date donationDate) {
        super(quantity, name);
        this.donationDate = donationDate;
    }

}
