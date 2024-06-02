package org.ijb.stock.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "tb_doador")
@Data
public class Donor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nome")
    private String name;
    private String cpf;
    @Column(name = "telefone")
    private String phone;
    @OneToMany(mappedBy = "donor")
    private Set<Donation> donations;
    public Donor() {

    }

    public Donor(String name, String cpf, String phone) {
        this.name = name;
        this.phone = phone;
        this.cpf = cpf;
    }
}
