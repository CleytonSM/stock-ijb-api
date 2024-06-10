package org.ijb.stock.helper;

import org.ijb.stock.model.DonatedMaterial;
import org.ijb.stock.model.dto.DonatedMaterialCreateDTO;
import org.ijb.stock.model.dto.DonatedMaterialDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DonatedMaterialHelper {

    public DonatedMaterialDTO createDonatedMaterialDTO(DonatedMaterialCreateDTO donatedMaterialCreateDTO) {
        return new DonatedMaterialDTO(null, donatedMaterialCreateDTO.getName(),
                donatedMaterialCreateDTO.getQuantity(), donatedMaterialCreateDTO.getDonationDate());
    }

    public DonatedMaterial dtoToDonatedMaterial(DonatedMaterialDTO donatedMaterialDTO) {
        return new DonatedMaterial(donatedMaterialDTO.getQuantity(),
                donatedMaterialDTO.getName(), donatedMaterialDTO.getDonationDate());
    }

    public DonatedMaterialDTO donatedMaterialToDTO(DonatedMaterial donatedMaterial) {
        return new DonatedMaterialDTO(donatedMaterial.getId(), donatedMaterial.getName(),
                donatedMaterial.getQuantity(), donatedMaterial.getDonationDate());
    }

    public List<DonatedMaterialDTO> donatedMaterialsToDTO(List<DonatedMaterial> donatedMaterials) {
        List<DonatedMaterialDTO> donatedMaterialsDTO = new ArrayList<>();

        for (DonatedMaterial donatedMaterial : donatedMaterials) {
            donatedMaterialsDTO.add(donatedMaterialToDTO(donatedMaterial));
        }

        return donatedMaterialsDTO;
    }

    public DonatedMaterial donatedMaterialUpdateSetter(DonatedMaterial donatedMaterial, DonatedMaterialDTO donatedMaterialDTO) {
        donatedMaterial.setName(donatedMaterialDTO.getName());
        donatedMaterial.setQuantity(donatedMaterialDTO.getQuantity());
        donatedMaterial.setDonationDate(donatedMaterialDTO.getDonationDate());

        return donatedMaterial;
    }

    public DonatedMaterial donatedMaterialPatchUpdateSetter(DonatedMaterial donatedMaterial, DonatedMaterialDTO donatedMaterialDTO) {
        donatedMaterial.setName(donatedMaterialDTO.getName() != null
                ? donatedMaterialDTO.getName() : donatedMaterial.getName());
        donatedMaterial.setQuantity(donatedMaterialDTO.getQuantity() != null
                ? donatedMaterialDTO.getQuantity() : donatedMaterial.getQuantity());
        donatedMaterial.setDonationDate(donatedMaterialDTO.getDonationDate() != null
                ? donatedMaterialDTO.getDonationDate() : donatedMaterial.getDonationDate());

        return donatedMaterial;
    }
}
