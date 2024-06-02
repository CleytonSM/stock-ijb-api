package org.ijb.stock.service;

import org.ijb.stock.helper.OptionalHelper;
import org.ijb.stock.helper.UserHelper;
import org.ijb.stock.model.Donor;
import org.ijb.stock.model.User;
import org.ijb.stock.model.dto.DonorDTO;
import org.ijb.stock.model.dto.UserDTO;
import org.ijb.stock.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OptionalHelper optionalHelper;

    @Autowired
    private UserHelper userHelper;

    private void save(User user){ userRepository.save(user);}
    private void delete(User user){userRepository.delete(user);}

    @Transactional
    public void createUser(UserDTO userDTO){
        optionalHelper.isEntityAlreadyExists(userRepository.findByEmail(userDTO.getEmail()));

        save(userHelper.dtoToUser(userDTO));
    }

    public UserDTO findUserById(Integer id) {
        User user = optionalHelper.verifyOptionalEntity(userRepository.findById(id));

        return userHelper.userToDTO(user);
    }

    public List<UserDTO> findAll() {
        return userHelper.usersToDTO(userRepository.findAll());
    }

    @Transactional
    public void updateUserById(Integer id, UserDTO userDTO) {
        User user = optionalHelper.verifyOptionalEntity(userRepository.findById(id));

        if(!userDTO.getEmail().equals(user.getEmail())) {
            optionalHelper.isEntityAlreadyExists(userRepository.findByEmail(userDTO.getEmail()));
        }

        userRepository.save(userHelper.userUpdateSetter(user, userDTO));
    }

    @Transactional
    public void patchUserById(Integer id, UserDTO userDTO) {
        User user = optionalHelper.verifyOptionalEntity(userRepository.findById(id));

        if(userDTO.getEmail() != null && !userDTO.getEmail().equals(user.getEmail()) ) {
            optionalHelper.isEntityAlreadyExists(userRepository.findByEmail(userDTO.getEmail()));
        }

        userRepository.save(userHelper.userPatchUpdateSetter(user, userDTO));
    }

    @Transactional
    public void deleteUserById(Integer id) {
        User user  = optionalHelper.verifyOptionalEntity(userRepository.findById(id));

        delete(user);
    }


}
