package org.ijb.stock.service;

import jakarta.persistence.Table;
import jakarta.transaction.Transactional;
import org.ijb.stock.helper.OptionalHelper;
import org.ijb.stock.model.Donor;
import org.ijb.stock.model.dto.DonorDTO;
import org.ijb.stock.repository.DonorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DonorService {

    @Autowired
    private DonorRepository donorRepository;

    @Autowired
    private OptionalHelper optionalHelper;

    private void save(Donor donor) {
        donorRepository.save(donor);
    }

    @Transactional
    public void createDonor(DonorDTO donorDTO) {
        optionalHelper.isEntityAlreadyExists(donorRepository.findByCpf(donorDTO.getCpf()));

        Donor donor = new Donor(donorDTO.getName(), donorDTO.getCpf(), donorDTO.getPhone());

        save(donor);
    }
}
