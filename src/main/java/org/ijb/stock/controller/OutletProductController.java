package org.ijb.stock.controller;

import org.ijb.stock.model.dto.OutletProductDTO;
import org.ijb.stock.service.OutletProductService;
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
@RequestMapping("/api/v1/outletproduct")
public class OutletProductController {

    @Autowired
    private OutletProductService outletProductService;

    @PostMapping("/create")
    public ResponseEntity<HttpStatus> createOutletProduct(@RequestBody OutletProductDTO outletProductDTO) {
        outletProductService.createOutletProduct(outletProductDTO);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/find/")
    public ResponseEntity<OutletProductDTO> findOutletProductById(@RequestParam Integer id) {
        return new ResponseEntity<>(outletProductService.findOutletProductById(id), HttpStatus.OK);
    }

    @GetMapping("/find/all")
    public ResponseEntity<List<OutletProductDTO>> findAllOutletProduct() {
        return new ResponseEntity<>(outletProductService.findAll(), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<HttpStatus> updateOutletProductById(@RequestParam Integer id, @RequestBody OutletProductDTO outletProductDTO) {
        outletProductService.updateOutletProductById(id, outletProductDTO);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/patch/")
    public ResponseEntity<HttpStatus> patchOutletProductById(@RequestParam Integer id, @RequestBody OutletProductDTO outletProductDTO) {
        outletProductService.patchOutletProductById(id, outletProductDTO);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/")
    public ResponseEntity<HttpStatus> deleteOutletProductById(@RequestParam Integer id) {
        outletProductService.deleteOutletProductById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
