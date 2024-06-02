package org.ijb.stock.model.dto;

import lombok.Data;

@Data
public class UserDTO {

    private Integer id;
    private String email;
    private String senha;

    public UserDTO(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public UserDTO(Integer id, String email, String senha) {
        this.id = id;
        this.email = email;
        this.senha = senha;
    }
}
