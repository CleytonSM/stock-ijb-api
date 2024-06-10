package org.ijb.stock.controller;

import org.ijb.stock.model.dto.DonatedMaterialCreateDTO;
import org.ijb.stock.model.dto.DonatedMaterialDTO;
import org.ijb.stock.service.DonatedMaterialService;
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
@RequestMapping("/api/v1/donatedmaterial")
public class DonatedMaterialController {

    @Autowired
    private DonatedMaterialService service;

    @PostMapping("/create")
    public ResponseEntity<HttpStatus> createDonatedMaterial(
                                                            @RequestBody DonatedMaterialCreateDTO donatedMaterialCreateDTO) {
        service.createDonatedMaterial(donatedMaterialCreateDTO);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/find/")
    public ResponseEntity<DonatedMaterialDTO> findDonatedMaterial(@RequestParam Integer id) {
        return new ResponseEntity<>(service.findDonatedMaterialById(id), HttpStatus.OK);
    }

    @GetMapping("/find/all")
    public ResponseEntity<List<DonatedMaterialDTO>> findAllDonatedMaterial() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @PutMapping("/update/")
    public ResponseEntity<HttpStatus> updateDonatedMaterialById(
            @RequestParam Integer id,
            @RequestBody DonatedMaterialCreateDTO donatedMaterialCreateDTO) {
        service.updateDonatedMaterialById(id, donatedMaterialCreateDTO);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/patch/")
    public ResponseEntity<HttpStatus> patchDonatedMaterialById(
            @RequestParam Integer id,
            @RequestBody DonatedMaterialCreateDTO donatedMaterialCreateDTO) {
        service.patchDonatedMaterialById(id, donatedMaterialCreateDTO);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/")
    public ResponseEntity<HttpStatus> deleteDonatedMaterialById(@RequestParam Integer id) {
        service.deleteDonatedMaterialById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
