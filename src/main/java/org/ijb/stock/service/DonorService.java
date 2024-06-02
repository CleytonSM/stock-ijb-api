package org.ijb.stock.service;

import jakarta.transaction.Transactional;
import org.ijb.stock.helper.DonorHelper;
import org.ijb.stock.helper.OptionalHelper;
import org.ijb.stock.model.Donor;
import org.ijb.stock.model.dto.DonorDTO;
import org.ijb.stock.repository.DonorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonorService {

    @Autowired
    private DonorRepository donorRepository;

    @Autowired
    private OptionalHelper optionalHelper;

    @Autowired
    private DonorHelper donorHelper;

    private void save(Donor donor) {
        donorRepository.save(donor);
    }
    private void delete(Donor donor) {
        donorRepository.delete(donor);
    }

    @Transactional
    public void createDonor(DonorDTO donorDTO) {
        optionalHelper.isEntityAlreadyExists(donorRepository.findByCpf(donorDTO.getCpf()));

        save(donorHelper.dtoToDonor(donorDTO));
    }

    public DonorDTO findDonorById(Integer id) {
        Donor donor = optionalHelper.verifyOptionalEntity(donorRepository.findById(id));

        return donorHelper.donorToDTO(donor);
    }

    public List<DonorDTO> findAll() {
        return donorHelper.donorsToDTO(donorRepository.findAll());
    }

    @Transactional
    public void updateDonorById(Integer id, DonorDTO donorDTO) {
        Donor donor = optionalHelper.verifyOptionalEntity(donorRepository.findById(id));

        if(!donorDTO.getCpf().equals(donor.getCpf())) {
            optionalHelper.isEntityAlreadyExists(donorRepository.findByCpf(donorDTO.getCpf()));
        }

        save(donorHelper.donorUpdateSetter(donor, donorDTO));
    }

    @Transactional
    public void patchDonorById(Integer id, DonorDTO donorDTO) {
        Donor donor = optionalHelper.verifyOptionalEntity(donorRepository.findById(id));

        if(donor.getCpf() != null && !donorDTO.getCpf().equals(donor.getCpf())) {
            optionalHelper.isEntityAlreadyExists(donorRepository.findByCpf(donorDTO.getCpf()));
        }

        save(donorHelper.donorPatchUpdateSetter(donor, donorDTO));
    }

    @Transactional
    public void deleteDonorById(Integer id) {
        Donor donor  = optionalHelper.verifyOptionalEntity(donorRepository.findById(id));

        delete(donor);
    }

    public Donor getById(Integer idDonor) {
        return optionalHelper.verifyOptionalEntity(donorRepository.findById(idDonor));
    }
}
