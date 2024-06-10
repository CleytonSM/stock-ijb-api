package org.ijb.stock.controller;

import org.ijb.stock.model.dto.MaterialDTO;
import org.ijb.stock.service.MaterialService;
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
@RequestMapping("/api/v1/material")
public class MaterialController {

    @Autowired
    private MaterialService service;

    @PostMapping("/create")
    public ResponseEntity<HttpStatus> createMaterial(@RequestBody MaterialDTO materialDTO) {
        service.createMaterial(materialDTO);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/find/")
    public ResponseEntity<MaterialDTO> findMaterial(@RequestParam Integer id) {
        return new ResponseEntity<>(service.findMaterialById(id), HttpStatus.OK);
    }

    @GetMapping("/find/all")
    public ResponseEntity<List<MaterialDTO>> findAllMaterial() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @PutMapping("/update/")
    public ResponseEntity<HttpStatus> updateMaterialById(@RequestParam Integer id, @RequestBody MaterialDTO materialDTO) {
        service.updateMaterialById(id, materialDTO);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/patch/")
    public ResponseEntity<HttpStatus> patchMaterialById(@RequestParam Integer id, @RequestBody MaterialDTO materialDTO) {
        service.patchMaterialById(id, materialDTO);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/")
    public ResponseEntity<HttpStatus> deleteMaterialById(@RequestParam Integer id) {
        service.deleteMaterialById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
