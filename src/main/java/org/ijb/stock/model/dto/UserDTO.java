package org.ijb.stock.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserDTO {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer id;
    private String email;
    private String password;



    public UserDTO(Integer id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }
}
