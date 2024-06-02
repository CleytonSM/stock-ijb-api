package org.ijb.stock.controller;

import org.ijb.stock.model.Donor;
import org.ijb.stock.model.dto.DonorDTO;
import org.ijb.stock.service.DonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/donor")
public class DonorController {

    @Autowired
    private DonorService donorService;

    @PostMapping("/register")
    public ResponseEntity<HttpStatus> registerDonor(@RequestBody DonorDTO donorDTO) {
        donorService.createDonor(donorDTO);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}
