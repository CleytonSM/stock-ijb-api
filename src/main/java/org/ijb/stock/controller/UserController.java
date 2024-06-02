package org.ijb.stock.controller;

import org.ijb.stock.model.dto.DonorDTO;
import org.ijb.stock.model.dto.UserDTO;
import org.ijb.stock.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<HttpStatus> registerUser(@RequestBody UserDTO userDTO) {
        userService.createUser(userDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/find/")
    public ResponseEntity<UserDTO> findUserById(@RequestParam Integer id){
        return new ResponseEntity<>(userService.findUserById(id), HttpStatus.OK);
    }

    @GetMapping("/find/all")
    public ResponseEntity<List<UserDTO>> findAllUsers() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }


    @PutMapping("/update/")
    public ResponseEntity<HttpStatus> updateUserById(@RequestParam Integer id, @RequestBody UserDTO userDTO) {
        userService.updateUserById(id, userDTO);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/patch/")
    public ResponseEntity<HttpStatus> patchUserById(@RequestParam Integer id, @RequestBody UserDTO userDTO) {
        userService.patchUserById(id, userDTO);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/")
    public ResponseEntity<HttpStatus> deleteUserById(@RequestParam Integer id) {
        userService.deleteUserById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
