package org.ijb.stock.repository;

import org.ijb.stock.model.OutletProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OutletProductRepository extends JpaRepository<OutletProduct, Integer> {

}
