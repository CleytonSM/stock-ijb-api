package org.ijb.stock.service;

import jakarta.transaction.Transactional;
import org.ijb.stock.helper.DonationHelper;
import org.ijb.stock.helper.OptionalHelper;
import org.ijb.stock.model.Donation;
import org.ijb.stock.model.dto.DonationDTO;
import org.ijb.stock.repository.DonationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonationService {

    @Autowired
    private DonationRepository donationRepository;

    @Autowired
    private OptionalHelper optionalHelper;

    @Autowired
    private DonationHelper donationHelper;

    private void save(Donation donation) {
        donationRepository.save(donation);
    }

    private void delete(Donation donation) {
        donationRepository.delete(donation);
    }

    @Transactional
    public void createDonation(DonationDTO donationDTO) {
        save(donationHelper.dtoToDonation(donationDTO));
    }

    public DonationDTO findDonationById(Integer id) {
        Donation donation = optionalHelper.verifyOptionalEntity(donationRepository.findById(id));

        return donationHelper.donationToDTO(donation);
    }

    public List<DonationDTO> findAll() {
        return donationHelper.donationsToDTO(donationRepository.findAll());
    }

    @Transactional
    public void updateDonationById(Integer id, DonationDTO donationDTO) {
        Donation donation = optionalHelper.verifyOptionalEntity(donationRepository.findById(id));

        save(donationHelper.donationUpdateSetter(donation, donationDTO));
    }

    @Transactional
    public void patchDonationById(Integer id, DonationDTO donationDTO) {
        Donation donation = optionalHelper.verifyOptionalEntity(donationRepository.findById(id));

        save(donationHelper.donationPatchUpdateSetter(donation, donationDTO));
    }

    @Transactional
    public void deleteDonationById(Integer id) {
        Donation donation = optionalHelper.verifyOptionalEntity(donationRepository.findById(id));

        delete(donation);
    }

    public Donation getById(Integer idDonation) {
        return optionalHelper.verifyOptionalEntity(donationRepository.findById(idDonation));
    }
}
