package com.undergrowth.undergrowth.repositories;


import com.undergrowth.undergrowth.models.UserProfile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepository extends CrudRepository<UserProfile, Long> {
    Iterable<UserProfile> findUserProfilesByType(String type);
    //Iterable<UserProfile> findUserProfilesByTypeAAndZipcode(String type, String zipcode);

}
