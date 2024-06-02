package org.ijb.stock.repository;

import org.ijb.stock.model.Donor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DonorRepository extends JpaRepository<Donor, Integer> {

    Optional<Object> findByCpf(String cpf);
}
