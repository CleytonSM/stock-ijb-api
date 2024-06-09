package org.ijb.stock.service;

import jakarta.transaction.Transactional;
import org.ijb.stock.model.DonatedMaterial;
import org.ijb.stock.repository.DonatedMaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DonatedMaterialService {

    @Autowired
    private DonatedMaterialRepository repository;

    private void save(DonatedMaterial donatedMaterial) {
        repository.save(donatedMaterial);
    }

}
