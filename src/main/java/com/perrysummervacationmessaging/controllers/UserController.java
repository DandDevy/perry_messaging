package com.perrysummervacationmessaging.controllers;

import com.perrysummervacationmessaging.entities.User;
import com.perrysummervacationmessaging.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * UserController is the controller for all user endpoints.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * create makes a new User and returns it with 201 or returns only 409.
     */
    @PostMapping
    public ResponseEntity<User> create(){
        User user = userService.create();
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    /**
     * findall finds all users and returns them with 200 or returns only 404.
     */
    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> users = userService.findAll();
        if (users == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
