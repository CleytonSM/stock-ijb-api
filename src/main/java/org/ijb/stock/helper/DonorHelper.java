package org.ijb.stock.helper;

import org.ijb.stock.model.Donor;
import org.ijb.stock.model.dto.DonorDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DonorHelper {

    public DonorDTO donorToDTO(Donor donor) {
        return new DonorDTO(donor.getId(), donor.getCpf(), donor.getName(), donor.getPhone());
    }

    public List<DonorDTO> donorsToDTO(List<Donor> donors) {
        List<DonorDTO> donorDTOs = new ArrayList<>();

        for (Donor donor : donors) {
            donorDTOs.add(donorToDTO(donor));
        }

        return donorDTOs;
    }

    public Donor dtoToDonor(DonorDTO donorDTO) {
        return new Donor(donorDTO.getName(), donorDTO.getCpf(), donorDTO.getPhone());
    }

    public Donor donorUpdateSetter(Donor donor, DonorDTO donorDTO) {
        donor.setCpf(donorDTO.getCpf());
        donor.setName(donorDTO.getName());
        donor.setPhone(donorDTO.getPhone());

        return donor;
    }

    public Donor donorPatchUpdateSetter(Donor donor, DonorDTO donorDTO) {
        donor.setCpf(donorDTO.getCpf() != null ? donorDTO.getCpf() : donor.getCpf());
        donor.setName(donorDTO.getName() != null ? donorDTO.getName() : donor.getName());
        donor.setPhone(donorDTO.getPhone() != null ? donorDTO.getPhone() : donor.getPhone());

        return donor;
    }
}
