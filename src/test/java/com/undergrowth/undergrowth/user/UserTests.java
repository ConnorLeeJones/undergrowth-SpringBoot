package com.undergrowth.undergrowth.user;

import com.undergrowth.undergrowth.models.User;
import com.undergrowth.undergrowth.models.UserProfile;
import com.undergrowth.undergrowth.repositories.UserRepository;
import com.undergrowth.undergrowth.services.UserProfileService;
import com.undergrowth.undergrowth.services.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserTests {

    @Mock
    private UserRepository repository;

    @InjectMocks
    private UserService service;

    @InjectMocks
    private UserProfileService userProfileService;


    private List<User> stubUserEntities= Arrays.asList(
            new User("User1", "password", "first", "last", new UserProfile()),
            new User("User2", "password", "first", "last", new UserProfile()),
            new User("User3", "password", "first", "last", new UserProfile())
            );


    @Test
    public void find_All_Test(){
        when(service.findAll()).thenReturn(stubUserEntities);

        service.findAll();

        verify(repository, times(1)).findAll();
    }

    @Test
    public void find_By_Id_Test(){
        when(service.findUserById(1L)).thenReturn(stubUserEntities.get(0));

        service.findUserById(1L);

        verify(repository, times(1)).findUserById(1L);
    }


//    @Test
//    public void create_User_Test(){
//        when(userProfileService.create(stubUserEntities.get(1)).thenReturn(new UserProfile());
//        when(service.create(stubUserEntities.get(1))).thenReturn(stubUserEntities.get(1));
//
//
//        service.create(stubUserEntities.get(1));
//
//        verify(repository, times(1)).save(stubUserEntities.get(1));
//    }

}
