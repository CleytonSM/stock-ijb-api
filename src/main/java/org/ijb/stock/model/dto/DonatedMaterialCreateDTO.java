package org.ijb.stock.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class DonatedMaterialCreateDTO {

    private String name;
    private Long quantity;
    private Date donationDate;

}
