package org.ijb.stock.helper;

import org.ijb.stock.model.User;
import org.ijb.stock.model.dto.UserDTO;

public class UserHelper {
    public UserDTO userToDTO(User user) {
        return new UserDTO(user.getEmail(), user.getSenha());
    }
}
