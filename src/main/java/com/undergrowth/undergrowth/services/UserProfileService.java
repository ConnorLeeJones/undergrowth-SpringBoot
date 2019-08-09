package com.undergrowth.undergrowth.services;

import com.undergrowth.undergrowth.models.UserProfile;
import com.undergrowth.undergrowth.repositories.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfileService {

    private UserProfileRepository repository;


    @Autowired
    public UserProfileService(UserProfileRepository repository){
        this.repository = repository;
    }


    public Iterable<UserProfile> findAll(){
        return repository.findAll();
    }

    public UserProfile findUserProfileById(Long id){
        return repository.findById(id).get();
    }

    public UserProfile create(UserProfile profile){
        return repository.save(profile);
    }

    public UserProfile update(Long id, UserProfile profile){
        UserProfile ogProfile = repository.findById(id).get();
        ogProfile.setDescription(profile.getDescription());
        ogProfile.setEmail(profile.getEmail());
        ogProfile.setLinks(profile.getLinks());
        ogProfile.setType(profile.getType());
        ogProfile.setZipcode(profile.getZipcode());
        ogProfile.setUserFullName(ogProfile.getUser().getFirstName() + " " + ogProfile.getUser().getLastName());
        return repository.save(ogProfile);
    }

    public Iterable<UserProfile> findUserProfilesByType(String type){
        return repository.findUserProfilesByType(type);
    }

    public Iterable<UserProfile> findUserProfilesByTypeAndZipcode(String type, String zipcode){
        return repository.findUserProfilesByTypeAndZipcode(type, zipcode);
    }



}
