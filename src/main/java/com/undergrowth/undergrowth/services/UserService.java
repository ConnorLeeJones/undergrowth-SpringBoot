package com.undergrowth.undergrowth.services;

import com.undergrowth.undergrowth.models.User;
import com.undergrowth.undergrowth.models.UserProfile;
import com.undergrowth.undergrowth.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {


    private UserRepository repository;
    private UserProfileService userProfileService;


    @Autowired
    public UserService(UserRepository repository, UserProfileService userProfileService){
        this.repository = repository;
        this.userProfileService = userProfileService;
    }

    public Iterable<User> findAll(){
        return repository.findAll();
    }

    public User findUserById(Long id){
        return repository.findUserById(id);
    }

    public User findUserByUsername(String username){return repository.findUserByUsername(username);}

    public User create(User user){
//        return repository.save(user);
        User newUser = repository.save(user);
        UserProfile userProfile = this.userProfileService.create(new UserProfile());
        userProfile.setUserFullName(newUser.getFirstName() + " " + newUser.getLastName());
        newUser.setUserProfile(userProfile);
        return repository.save(newUser);
    }
//
//    public Iterable<User> findAllUsersByProfileType(String type){
//
//    }


}
