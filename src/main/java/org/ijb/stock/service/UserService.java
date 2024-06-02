package org.ijb.stock.service;

import org.ijb.stock.helper.OptionalHelper;
import org.ijb.stock.helper.UserHelper;
import org.ijb.stock.model.User;
import org.ijb.stock.model.dto.UserDTO;
import org.ijb.stock.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OptionalHelper optionalHelper;
    @Autowired
    private UserHelper userHelper;

    private void save(User user){ userRepository.save(user);}

    @Transactional
    public void createUser(UserDTO userDTO){
        optionalHelper.isEntityAlreadyExists(userRepository.findByEmail(userDTO.getEmail()));

        User user = new User(userDTO.getEmail(), userDTO.getSenha());

        save(user);
    }

    public User findUserById(Integer id) {
        User user = optionalHelper.verifyOptionalEntity(userRepository.findById(id));

        return userHelper.userToDTO(user);
    }



}
