package org.ijb.stock.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DonationDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer id;
    private Integer idDonor;
    private String description;
    private Long quantity;

    public DonationDTO() {
    }

    public DonationDTO(Integer id, Integer idDonor, String description, Long quantity) {
        this.id = id;
        this.description = description;
        this.idDonor = idDonor;
        this.quantity = quantity;
    }
}
