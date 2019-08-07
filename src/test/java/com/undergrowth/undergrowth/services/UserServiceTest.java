package com.undergrowth.undergrowth.services;

import com.undergrowth.undergrowth.models.User;
import com.undergrowth.undergrowth.repositories.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class UserServiceTest {

    @Mock
    private UserRepository mockRepository;
    @Mock
    private UserProfileService userProfileService;

    private UserService userService;

    @Before
    public void setUp() {
        initMocks(this);
        userService = new UserService(mockRepository, userProfileService);
    }

    @Test
    public void testFindAll() {
        Iterable<User> expectedResult = null;
        when(mockRepository.findAll()).thenReturn(null);

        Iterable<User> result = userService.findAll();

        assertEquals(expectedResult, result);
    }

    @Test
    public void testFindUserById() {
        Long id = 0L;
        User expectedResult = new User();
        when(mockRepository.findUserById(0L)).thenReturn(expectedResult);

        User result = userService.findUserById(id);

        assertEquals(expectedResult, result);
    }

    @Test
    public void testFindUserByUsername() {
        String username = "username";
        User expectedResult = null;
        when(mockRepository.findUserByUsername("username")).thenReturn(null);

        User result = userService.findUserByUsername(username);

        assertEquals(expectedResult, result);
    }

    @Test
    public void testCreate() {
        User user = null;
        User expectedResult = new User();
        when(mockRepository.save(null)).thenReturn(expectedResult);
        when(userProfileService.create(null)).thenReturn(null);

        User result = userService.create(user);

        assertEquals(expectedResult, result);
    }
}
