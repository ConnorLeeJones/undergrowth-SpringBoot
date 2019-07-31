package com.undergrowth.undergrowth.controllers;

import com.undergrowth.undergrowth.models.User;
import com.undergrowth.undergrowth.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class UserController {

    private UserService service;

    @Autowired
    public UserController(UserService service){
        this.service = service;
    }

    @GetMapping(value = "/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") Long id) {
        return new ResponseEntity<>(service.findUserById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/users")
    public ResponseEntity<Iterable<User>> getUsers() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }


    @PostMapping(value = "/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return new ResponseEntity<>(service.create(user), HttpStatus.CREATED);
    }




}
