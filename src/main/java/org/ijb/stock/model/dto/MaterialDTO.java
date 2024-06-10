package org.ijb.stock.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MaterialDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer id;
    private String name;
    private Long quantity;

    public MaterialDTO() {
    }

    public MaterialDTO(Integer id, String name, Long quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }
}
