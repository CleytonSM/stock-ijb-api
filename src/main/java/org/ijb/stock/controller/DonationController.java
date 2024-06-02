package org.ijb.stock.controller;

import org.ijb.stock.model.dto.DonationDTO;
import org.ijb.stock.service.DonationService;
import org.ijb.stock.service.DonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/donation")
public class DonationController {

    @Autowired
    private DonationService donationService;

    @PostMapping("/create")
    public ResponseEntity<HttpStatus> createDonation(@RequestBody DonationDTO donationDTO) {
        donationService.createDonation(donationDTO);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/find/")
    public ResponseEntity<DonationDTO> findDonationById(@RequestParam Integer id) {
        return new ResponseEntity<>(donationService.findDonationById(id), HttpStatus.OK);
    }

    @GetMapping("/find/all")
    public ResponseEntity<List<DonationDTO>> findAllDonations() {
        return new ResponseEntity<>(donationService.findAll(), HttpStatus.OK);
    }

    @PutMapping("/update/")
    public ResponseEntity<HttpStatus> updateDonationById(@RequestParam Integer id, @RequestBody DonationDTO donationDTO) {
        donationService.updateDonation(id, donationDTO);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/patch/")
    public ResponseEntity<HttpStatus> patchDonationById(@RequestParam Integer id, @RequestBody DonationDTO donationDTO) {
        donationService.patchDonation(id, donationDTO);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/")
    public ResponseEntity<HttpStatus> deleteDonationById(@RequestParam Integer id) {
        donationService.deleteDonation(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
