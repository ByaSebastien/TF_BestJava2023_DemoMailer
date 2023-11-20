package be.bstorm.services.impl;

import be.bstorm.models.entities.User;
import be.bstorm.repositories.UserRepository;
import be.bstorm.services.UserService;
import be.bstorm.utils.MailerUtils;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final MailerUtils mailerUtils;

    public UserServiceImpl(UserRepository userRepository, MailerUtils mailerUtils) {
        this.userRepository = userRepository;
        this.mailerUtils = mailerUtils;
    }

    @Override
    public User register(User user) {

        user.setPassword(UUID.randomUUID().toString());
        mailerUtils.sendPasswordByEmail(user.getEmail(),"Test", user.getPassword() );
        return userRepository.save(user);
    }
}
