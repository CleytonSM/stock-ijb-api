package org.ijb.stock.service;

import jakarta.transaction.Transactional;
import org.ijb.stock.helper.MaterialHelper;
import org.ijb.stock.helper.OptionalHelper;
import org.ijb.stock.model.Material;
import org.ijb.stock.model.dto.MaterialDTO;
import org.ijb.stock.repository.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialService {

    @Autowired
    private MaterialRepository repository;
    @Autowired
    private OptionalHelper optionalHelper;
    @Autowired
    private MaterialHelper materialHelper;

    private void save(Material material) {
        repository.save(material);
    }
    private void delete(Material material) {
        repository.delete(material);
    }

    public void createMaterial(MaterialDTO materialDTO) {
        save(materialHelper.dtoToMaterial(materialDTO));
    }

    public MaterialDTO findMaterialById(Integer id) {
        Material material = optionalHelper.verifyOptionalEntity(repository.findById(id));

        return materialHelper.materialToDTO(material);
    }

    public List<MaterialDTO> findAll() {
        return materialHelper.materialsToDTO(repository.findAll());
    }

    @Transactional
    public void updateMaterialById(Integer id, MaterialDTO materialDTO) {
        Material material = optionalHelper.verifyOptionalEntity(repository.findById(id));

        save(materialHelper.materialUpdateSetter(material, materialDTO));
    }

    @Transactional
    public void patchMaterialById(Integer id, MaterialDTO materialDTO) {
        Material material = optionalHelper.verifyOptionalEntity(repository.findById(id));

        save(materialHelper.materialPatchUpdateSetter(material, materialDTO));
    }

    @Transactional
    public void deleteMaterialById(Integer id) {
        Material material = optionalHelper.verifyOptionalEntity(repository.findById(id));

        delete(material);
    }
}
