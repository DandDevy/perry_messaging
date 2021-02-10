package com.perrysummervacationmessaging.services;

import com.perrysummervacationmessaging.entities.User;

import java.util.List;
import java.util.UUID;

/**
 * UserService is the interface for using User service
 */
public interface UserService {
    /**
     * Creates a new User for the system and returns it.
     * @return User
     */
    public User create();

    /**
     * Get a list
     * @return List<User>
     */
    List<User> findAll();
}
