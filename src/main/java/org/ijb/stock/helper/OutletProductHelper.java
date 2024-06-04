package org.ijb.stock.helper;

import org.ijb.stock.model.OutletProduct;
import org.ijb.stock.model.dto.OutletProductDTO;
import org.ijb.stock.service.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OutletProductHelper {

    @Autowired
    private DonationService donationService;

    public OutletProduct dtoToDonor(OutletProductDTO outletProductDTO) {
        return new OutletProduct(donationService.getById(outletProductDTO.getIdDonation()), outletProductDTO.getName(),
                outletProductDTO.getDescription());
    }

    public OutletProductDTO outletProductToDTO(OutletProduct outletProduct) {
        return new OutletProductDTO(outletProduct.getId(), outletProduct.getDonation().getId(),
                outletProduct.getName(), outletProduct.getDescription());
    }

    public List<OutletProductDTO> outletProductsToDTO(List<OutletProduct> outletProducts) {
        List<OutletProductDTO> outletProductDTOs = new ArrayList<>();

        for (OutletProduct outletProduct : outletProducts) {
            outletProductDTOs.add(outletProductToDTO(outletProduct));
        }

        return outletProductDTOs;
    }

    public OutletProduct outletProductUpdateSetter(OutletProduct outletProduct, OutletProductDTO outletProductDTO) {
        outletProduct.setDonation(donationService.getById(outletProductDTO.getIdDonation()));
        outletProduct.setName(outletProductDTO.getName());
        outletProduct.setDescription(outletProductDTO.getDescription());

        return outletProduct;
    }

    public OutletProduct outletProductPatchUpdateSetter(OutletProduct outletProduct, OutletProductDTO outletProductDTO) {
        outletProduct.setDonation(outletProductDTO.getIdDonation() != null
                ? donationService.getById(outletProductDTO.getIdDonation()) : outletProduct.getDonation());
        outletProduct.setName(outletProductDTO.getName() != null
                ? outletProductDTO.getName() : outletProduct.getName());
        outletProduct.setDescription(outletProductDTO.getDescription() != null
                ? outletProductDTO.getDescription() : outletProduct.getDescription());

        return outletProduct;
    }
}
