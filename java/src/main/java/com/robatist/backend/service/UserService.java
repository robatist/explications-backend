package com.robatist.backend.service;

import com.robatist.backend.domain.user.User;
import com.robatist.backend.exception.UserNotFoundException;
import com.robatist.backend.exception.UsersNotFoundException;
import com.robatist.backend.logging.Logger;
import com.robatist.backend.logging.enumeration.LogTag;
import com.robatist.backend.repository.UserRepository;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private static final Logger LOGGER = new Logger(UserService.class);
    private final UserRepository userRepository;

    @Autowired
    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        final List<User> userList = userRepository.findAll();

        if (userList.isEmpty()) {
            throw new UsersNotFoundException();
        }

        LOGGER.info(MDC.get("correlationId"), Arrays.asList(LogTag.USERS, LogTag.RETRIEVED),
                "All Users Retrieved.");

        return userList;
    }

    public User getUserById(final int id) {
        final Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isEmpty()) {
            throw new UserNotFoundException(id);
        }

        LOGGER.info(MDC.get("correlationId"), Arrays.asList(LogTag.USERS, LogTag.RETRIEVED),
                MessageFormat.format("User {0} Retrieved.", id));

        return userOptional.get();
    }

    public User getUserByEmail(final String email) {
        final Optional<User> userOptional = userRepository.findUserByEmail(email);

        if (userOptional.isEmpty()) {
            throw new UserNotFoundException(email);
        }

        LOGGER.info(MDC.get("correlationId"), Arrays.asList(LogTag.USERS, LogTag.RETRIEVED),
                MessageFormat.format("User with ''{0}'' as email Retrieved.", email));

        return userOptional.get();
    }

    public User createUser(final User user) {

        LOGGER.info(MDC.get("correlationId"), Arrays.asList(LogTag.USERS, LogTag.CREATED), "User Created.");

        return userRepository.save(user);
    }

    public User updateUser(int id, User user) {
        final Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isEmpty()) {
            throw new UserNotFoundException(id);
        }

        User userUpdated = userOptional.get();

        userUpdated = new User.UserBuilder(userUpdated) //
                .firstName(user.getFirstName()) //
                .lastName(user.getLastName()) //
                .email(user.getEmail()) //
                .password(user.getPassword()) //
                .age(user.getAge()) //
                .nif(user.getNif()) //
                .photo(user.getPhoto()) //
                .active(user.isActive()) //
                .role(user.getRole()) //
                .build();

        LOGGER.info(MDC.get("correlationId"), Arrays.asList(LogTag.USERS, LogTag.UPDATED), MessageFormat.format("User {0} Updated.", id));

        return userRepository.save(userUpdated);
    }

    public void deleteUser(final int id) {
        final Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isEmpty()) {
            throw new UserNotFoundException(id);
        }

        LOGGER.info(MDC.get("correlationId"), Arrays.asList(LogTag.USERS, LogTag.DELETED), MessageFormat.format("User {0} deleted.", id));

        userRepository.deleteById(id);
    }


}
