package org.ijb.stock.service;

import jakarta.transaction.Transactional;
import org.ijb.stock.helper.DonatedMaterialHelper;
import org.ijb.stock.helper.OptionalHelper;
import org.ijb.stock.model.DonatedMaterial;
import org.ijb.stock.model.dto.DonatedMaterialCreateDTO;
import org.ijb.stock.model.dto.DonatedMaterialDTO;
import org.ijb.stock.repository.DonatedMaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonatedMaterialService {

    @Autowired
    private DonatedMaterialRepository repository;
    @Autowired
    private OptionalHelper optionalHelper;
    @Autowired
    private DonatedMaterialHelper donatedMaterialHelper;

    private void save(DonatedMaterial donatedMaterial) {
        repository.save(donatedMaterial);
    }

    private void delete(DonatedMaterial donatedMaterial) {
        repository.delete(donatedMaterial);
    }

    public void createDonatedMaterial(DonatedMaterialCreateDTO donatedMaterialCreateDTO) {
        DonatedMaterialDTO donatedMaterialDTO = donatedMaterialHelper
                .createDonatedMaterialDTO(donatedMaterialCreateDTO);

        save(donatedMaterialHelper.dtoToDonatedMaterial(donatedMaterialDTO));
    }

    public DonatedMaterialDTO findDonatedMaterialById(Integer id) {
        DonatedMaterial donatedMaterial = optionalHelper.verifyOptionalEntity(repository.findById(id));

        return donatedMaterialHelper.donatedMaterialToDTO(donatedMaterial);
    }

    public List<DonatedMaterialDTO> findAll() {
        return donatedMaterialHelper.donatedMaterialsToDTO(repository.findAll());
    }

    @Transactional
    public void updateDonatedMaterialById(Integer id, DonatedMaterialCreateDTO donatedMaterialCreateDTO) {
        DonatedMaterial donatedMaterial = optionalHelper.verifyOptionalEntity(repository.findById(id));
        DonatedMaterialDTO donatedMaterialDTO = donatedMaterialHelper
                .createDonatedMaterialDTO(donatedMaterialCreateDTO);

        save(donatedMaterialHelper.donatedMaterialUpdateSetter(donatedMaterial, donatedMaterialDTO));
    }

    @Transactional
    public void patchDonatedMaterialById(Integer id, DonatedMaterialCreateDTO donatedMaterialCreateDTO) {
        DonatedMaterial donatedMaterial = optionalHelper.verifyOptionalEntity(repository.findById(id));
        DonatedMaterialDTO donatedMaterialDTO = donatedMaterialHelper
                .createDonatedMaterialDTO(donatedMaterialCreateDTO);

        save(donatedMaterialHelper.donatedMaterialPatchUpdateSetter(donatedMaterial, donatedMaterialDTO));
    }

    @Transactional
    public void deleteDonatedMaterialById(Integer id) {
        DonatedMaterial donatedMaterial = optionalHelper.verifyOptionalEntity(repository.findById(id));

        delete(donatedMaterial);
    }
}
