package org.ijb.stock.service;

import org.ijb.stock.model.Material;
import org.ijb.stock.repository.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaterialService {

    @Autowired
    private MaterialRepository repository;

    private void save(Material material) {
        repository.save(material);
    }
    private void delete(Material material) {
        repository.delete(material);
    }


}
