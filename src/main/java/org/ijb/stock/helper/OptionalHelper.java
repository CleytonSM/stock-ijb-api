package org.ijb.stock.helper;

import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class OptionalHelper {

    public <T> T verifyOptionalEntity(Optional<T> t) {
        if(t.isEmpty()) {
            throw new RuntimeException("This entity does not exist");
        }

        return t.get();
    }

    public <T> void entityAlreadyExists(Optional<T> t) {
        if(t.isPresent()) {
            throw new RuntimeException("This entity already exists");
        }
    }
}
