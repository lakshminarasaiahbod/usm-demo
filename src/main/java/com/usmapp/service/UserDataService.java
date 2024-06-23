package com.usmapp.service;

import com.usmapp.entity.UserData;
import com.usmapp.exception.UserRegException;
import com.usmapp.repository.UserDataRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserDataService {

    private final UserDataRepository userDataRepository;

    // Constructor to inject the UserDataRepository dependency
    public UserDataService(UserDataRepository userDataRepository) {
        this.userDataRepository = userDataRepository;
    }

    /**
     * Creates a new user.
     *
     * @param user The user data to be created.
     * @return The created user data.
     * @throws UserRegException if a user with the given email already exists.
     */
    public UserData createUser(UserData user) {
        // Check if the user already exists by email
        if (userDataRepository.existsById(user.getEmail())) {
            throw new UserRegException("User with email " + user.getEmail() + " already exists");
        }
        // Save and return the new user
        return userDataRepository.save(user);
    }

    /**
     * Updates an existing user.
     *
     * @param user The user data to be updated.
     * @return The updated user data.
     * @throws UserRegException if a user with the given email does not exist.
     */
    public UserData updateUser(UserData user) {
        // Check if the user exists by email
        if (!userDataRepository.existsById(user.getEmail())) {
            throw new UserRegException("User with email " + user.getEmail() + " does not exist");
        }
        // Save and return the updated user
        return userDataRepository.save(user);
    }
}
