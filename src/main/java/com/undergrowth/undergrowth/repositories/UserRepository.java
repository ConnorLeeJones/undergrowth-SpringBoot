package com.undergrowth.undergrowth.repositories;


import com.undergrowth.undergrowth.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Iterator;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findUserById(Long id);
    User findUserByUsername(String username);

    //Iterable<User> findAllUsersByProfileType(String type);

//    @Query("SELECT u FROM User u WHERE u.status = ?1")
//    @Query("SELECT u.id, u.first_name, u.last_name, up.type, up.zipcode FROM user u INNER JOIN user_profile up ON u.id=up.id WHERE up.type=? AND up.zipcode=?")
//    Iterable<User> findUserByProfileTypeAndZipcode(Integer status);
//
//

}
