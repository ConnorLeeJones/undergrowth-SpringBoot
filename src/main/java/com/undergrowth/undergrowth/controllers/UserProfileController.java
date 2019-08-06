package com.undergrowth.undergrowth.controllers;


import com.undergrowth.undergrowth.models.UserProfile;
import com.undergrowth.undergrowth.services.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value ="/profiles")
@CrossOrigin
public class UserProfileController {

    private UserProfileService service;

    @Autowired
    public UserProfileController(UserProfileService service){ this.service = service; }

    @GetMapping
    public ResponseEntity<Iterable<UserProfile>> getAllProfiles() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<UserProfile> getUserProfile(@PathVariable("id") Long id) {
        return new ResponseEntity<>(service.findUserProfileById(id), HttpStatus.OK);
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<UserProfile> updateUserProfile(@PathVariable Long id, @RequestBody UserProfile profile) {
        return new ResponseEntity<>(service.update(id, profile), HttpStatus.OK);
    }

    @GetMapping(value = "/all/{type}")
    public ResponseEntity<Iterable<UserProfile>> getUserProfileByType(@PathVariable("type") String type) {
        return new ResponseEntity<>(service.findUserProfilesByType(type), HttpStatus.OK);
    }

//    @PutMapping(value = "/local/{type}")
//    public ResponseEntity<Iterable<UserProfile>> getLocalUserProfileByType(@PathVariable("type") String type, @RequestBody UserProfile profile) {
//        return new ResponseEntity<>(service.findUserProfilesByTypeAndZipcode(type, profile.getZipcode()), HttpStatus.OK);
//    }
}
