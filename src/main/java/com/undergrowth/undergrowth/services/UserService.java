package com.undergrowth.undergrowth.services;

import com.undergrowth.undergrowth.models.User;
import com.undergrowth.undergrowth.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {


    private UserRepository repository;


    @Autowired
    public UserService(UserRepository repository){
        this.repository = repository;
    }

    public Iterable<User> findAll(){
        return repository.findAll();
    }

    public User findUserById(Long id){
        return repository.findUserById(id);
    }

    public User create(User user){
        //User newUser = new User(user.getUsername(), user.getPassword(), user.getFirstName(), user.getLastName());
        return repository.save(user);
    }

}
