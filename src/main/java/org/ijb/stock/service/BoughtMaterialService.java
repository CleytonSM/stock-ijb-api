package org.ijb.stock.service;

import jakarta.transaction.Transactional;
import org.ijb.stock.model.BoughtMaterial;
import org.ijb.stock.model.DonatedMaterial;
import org.ijb.stock.repository.BoughtMaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoughtMaterialService {

    @Autowired
    private BoughtMaterialRepository repository;

    private void save (BoughtMaterial boughtMaterial) {
        repository.save(boughtMaterial);
    }
    private void delete(BoughtMaterial boughtMaterial) {
        repository.delete(boughtMaterial);
    }

}
