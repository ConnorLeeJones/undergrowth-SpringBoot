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
        return repository.save(profile);
    }


}
