package org.ijb.stock.helper;

import org.ijb.stock.model.Material;
import org.ijb.stock.model.dto.DonatedMaterialDTO;
import org.ijb.stock.model.dto.MaterialDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MaterialHelper {

    public Material dtoToMaterial(MaterialDTO materialDTO) {
        return new Material(materialDTO.getQuantity(), materialDTO.getName());
    }

    public MaterialDTO materialToDTO(Material material) {
        return new MaterialDTO(material.getId(), material.getName(), material.getQuantity());
    }

    public List<MaterialDTO> materialsToDTO(List<Material> materials) {
        List<MaterialDTO> materialsDTO = new ArrayList<>();

        for (Material material : materials) {
            materialsDTO.add(materialToDTO(material));
        }

        return materialsDTO;
    }

    public Material materialUpdateSetter(Material material, MaterialDTO materialDTO) {
        material.setName(materialDTO.getName());
        material.setQuantity(materialDTO.getQuantity());

        return material;
    }

    public Material materialPatchUpdateSetter(Material material, MaterialDTO materialDTO) {
        material.setName(materialDTO.getName() != null
                ? materialDTO.getName() : material.getName());
        material.setQuantity(materialDTO.getQuantity() != null ? materialDTO.getQuantity() : material.getQuantity());

        return material;
    }
}
