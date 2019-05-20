package org.cicr.camel.central.service;

import org.cicr.camel.central.entity.UserEty;
import org.cicr.camel.central.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEty getOrInitUser(final String uuid) {
        UserEty user = userRepository.findByUuid(uuid);

        if (user == null) {
            user = new UserEty();
            user.setUuid(uuid);
            user.setCreator(1);
            user.setDateCreated("1970-01-01 00:00:00");
            user.setSystemId("admin");
            user.setPersonId(1);
        }

        return user;
    }
}
