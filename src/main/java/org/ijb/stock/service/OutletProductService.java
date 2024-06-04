package org.ijb.stock.service;

import jakarta.transaction.Transactional;
import org.ijb.stock.helper.OptionalHelper;
import org.ijb.stock.helper.OutletProductHelper;
import org.ijb.stock.model.OutletProduct;
import org.ijb.stock.model.dto.OutletProductDTO;
import org.ijb.stock.repository.OutletProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OutletProductService {

    @Autowired
    private OutletProductRepository outletProductRepository;

    @Autowired
    private OptionalHelper optionalHelper;

    @Autowired
    private OutletProductHelper outletProductHelper;

    private void save(OutletProduct outletProduct) {
        outletProductRepository.save(outletProduct);
    }
    private void delete(OutletProduct outletProduct) {
        outletProductRepository.delete(outletProduct);
    }

    @Transactional
    public void createOutletProduct(OutletProductDTO outletProductDTO) {
        save(outletProductHelper.dtoToDonor(outletProductDTO));
    }

    public OutletProductDTO findOutletProductById(Integer id) {
        OutletProduct outletProduct = optionalHelper.verifyOptionalEntity(outletProductRepository.findById(id));

        return outletProductHelper.outletProductToDTO(outletProduct);
    }

    public List<OutletProductDTO> findAll() {
        return outletProductHelper.outletProductsToDTO(outletProductRepository.findAll());
    }

    @Transactional
    public void updateOutletProductById(Integer id, OutletProductDTO outletProductDTO) {
        OutletProduct outletProduct = optionalHelper.verifyOptionalEntity(outletProductRepository.findById(id));

        save(outletProductHelper.outletProductUpdateSetter(outletProduct, outletProductDTO));
    }

    @Transactional
    public void patchOutletProductById(Integer id, OutletProductDTO outletProductDTO) {
        OutletProduct outletProduct = optionalHelper.verifyOptionalEntity(outletProductRepository.findById(id));

        save(outletProductHelper.outletProductPatchUpdateSetter(outletProduct, outletProductDTO));
    }

    @Transactional
    public void deleteOutletProductById(Integer id) {
        OutletProduct outletProduct = optionalHelper.verifyOptionalEntity(outletProductRepository.findById(id));

        delete(outletProduct);
    }
}
