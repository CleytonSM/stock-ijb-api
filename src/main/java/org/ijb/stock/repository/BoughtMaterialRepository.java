package org.ijb.stock.repository;

import org.ijb.stock.model.BoughtMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoughtMaterialRepository extends JpaRepository<BoughtMaterial, Integer> {
}
