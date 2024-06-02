package org.ijb.stock.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DonorDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer id;
    private String name;
    private String cpf;
    private String phone;

    public DonorDTO(Integer id, String cpf, String name, String phone) {
        this.cpf = cpf;
        this.id = id;
        this.name = name;
        this.phone = phone;
    }
}
