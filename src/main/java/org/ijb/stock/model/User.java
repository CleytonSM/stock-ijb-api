package org.ijb.stock.model;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;

@Entity
@Table(name = "tb_users")
@Data
public class User {
    @Id
    @GeneratedValue(generator = "native", strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "email")
    private String email;
    @Column(name = "senha")
    private String senha;

    public User() {
    }

    public User(String email, String senha) {
        this.id = id;
        this.email = email;
        this.senha = senha;
    }
}
