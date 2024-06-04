package org.ijb.stock.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class OutletProductDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer id;
    private Integer idDonation;
    private String name;
    private String description;

    public OutletProductDTO() {
    }

    public OutletProductDTO(Integer id, Integer idDonation, String name, String description) {
        this.id = id;
        this.idDonation = idDonation;
        this.name = name;
        this.description = description;
    }
}
