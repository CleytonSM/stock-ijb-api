package org.ijb.stock.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "tb_doador")
@Data
public class Donor {

    @Id
    @GeneratedValue(generator = "native", strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "nome")
    private String name;
    private String cpf;
    @Column(name = "telefone")
    private String phone;

    public Donor() {

    }

    public Donor(String name, String cpf, String phone) {
        this.name = name;
        this.phone = phone;
        this.cpf = cpf;
    }
}
