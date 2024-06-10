package org.ijb.stock.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class DonatedMaterialDTO extends MaterialDTO{

    private Date donationDate;

    public DonatedMaterialDTO() {
    }

    public DonatedMaterialDTO(Integer id, String name, Long quantity, Date donationDate) {
        super(id, name, quantity);
        this.donationDate = donationDate;
    }

}
