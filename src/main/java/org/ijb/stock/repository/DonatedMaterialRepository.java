package org.ijb.stock.repository;

import org.ijb.stock.model.DonatedMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonatedMaterialRepository extends JpaRepository<DonatedMaterial, Integer> {
}
