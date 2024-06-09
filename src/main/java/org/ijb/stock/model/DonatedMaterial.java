package org.ijb.stock.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "tb_material_doado")
public class DonatedMaterial extends Material{

    @Column(name = "dt_docao")
    private Date dtDocao;

    public DonatedMaterial() {
    }

    public DonatedMaterial(Date dtDocao) {
        this.dtDocao = dtDocao;
    }

    public DonatedMaterial(Long quantity, String name, Date dtDocao) {
        super(quantity, name);
        this.dtDocao = dtDocao;
    }

}
