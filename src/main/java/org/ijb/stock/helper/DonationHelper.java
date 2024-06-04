package org.ijb.stock.helper;

import org.ijb.stock.model.Donation;
import org.ijb.stock.model.dto.DonationDTO;
import org.ijb.stock.service.DonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DonationHelper {

    @Autowired
    private DonorService donorService;

    public Donation dtoToDonation(DonationDTO donationDTO) {
        return new Donation(donorService.getById(donationDTO.getIdDonor()), donationDTO.getDescription(), donationDTO.getQuantity());
    }

    public DonationDTO donationToDTO(Donation donation) {
        return new DonationDTO(donation.getId(), donation.getDonor().getId(), donation.getDescription(), donation.getQuantity());
    }

    public List<DonationDTO> donationsToDTO(List<Donation> donations) {
        List<DonationDTO> donationDTOs = new ArrayList<>();
        for (Donation donation : donations) {
            donationDTOs.add(donationToDTO(donation));
        }

        return donationDTOs;
    }

    public Donation donationUpdateSetter(Donation donation, DonationDTO donationDTO) {
        donation.setDonor(donorService.getById(donationDTO.getIdDonor()));
        donation.setDescription(donationDTO.getDescription());
        donation.setQuantity(donationDTO.getQuantity());

        return donation;
    }

    public Donation donationPatchUpdateSetter(Donation donation, DonationDTO donationDTO) {
        donation.setDonor(donationDTO.getIdDonor() != null
                ? donorService.getById(donationDTO.getIdDonor()) : donation.getDonor());
        donation.setDescription(donationDTO.getDescription() != null
                ? donationDTO.getDescription() : donation.getDescription());
        donation.setQuantity(donationDTO.getQuantity() != null
                ? donationDTO.getQuantity() : donation.getQuantity());

        return donation;
    }
}
