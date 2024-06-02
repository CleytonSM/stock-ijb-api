package org.ijb.stock.helper;

import org.ijb.stock.model.User;
import org.ijb.stock.model.dto.UserDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserHelper {
    public UserDTO userToDTO(User user) {
        return new UserDTO(user.getId(), user.getEmail(), user.getPassword());
    }


    public List<UserDTO> usersToDTO(List<User> users) {
        List<UserDTO> userDTOS = new ArrayList<>();

        for (User user : users) {
            userDTOS.add(userToDTO(user));
        }

        return userDTOS;
    }

    public User dtoToUser(UserDTO userDTO) {
        return new User(userDTO.getEmail(), userDTO.getPassword());
    }

    public User userUpdateSetter(User user, UserDTO userDTO) {
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());

        return user;
    }

    public User userPatchUpdateSetter(User user, UserDTO userDTO) {
        user.setEmail(userDTO.getEmail() != null ? userDTO.getEmail() : user.getEmail());
        user.setPassword(userDTO.getPassword() != null ? userDTO.getPassword() : user.getPassword());

        return user;
    }


}
