package org.ijb.stock.controller;

import org.ijb.stock.model.dto.DonorDTO;
import org.ijb.stock.service.DonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/find/")
    public ResponseEntity<DonorDTO> findDonorById(@RequestParam Integer id) {
        return new ResponseEntity<>(donorService.findDonorById(id), HttpStatus.OK);
    }

    @GetMapping("/find/all")
    public ResponseEntity<List<DonorDTO>> findAllDonors() {
        return new ResponseEntity<>(donorService.findAll(), HttpStatus.OK);
    }

    @PutMapping("/update/")
    public ResponseEntity<HttpStatus> updateDonorById(@RequestParam Integer id, @RequestBody DonorDTO donorDTO) {
        donorService.updateDonorById(id, donorDTO);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/patch/")
    public ResponseEntity<HttpStatus> patchDonorById(@RequestParam Integer id, @RequestBody DonorDTO donorDTO) {
        donorService.patchDonorById(id, donorDTO);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/")
    public ResponseEntity<HttpStatus> deleteDonorById(@RequestParam Integer id) {
        donorService.deleteDonorById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
