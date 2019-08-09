package com.undergrowth.undergrowth.controllers;

import com.undergrowth.undergrowth.models.User;
import com.undergrowth.undergrowth.services.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class UserControllerTest {

    @Mock
    private UserService mockService;

    private UserController controller;

    @Before
    public void setUp() {
        initMocks(this);
        controller = new UserController(mockService);
    }

    @Test
    public void testGetUser() {
        Long id = 0L;
        ResponseEntity<User> expected = new ResponseEntity<>(null, HttpStatus.OK);
        when(mockService.findUserById(0L)).thenReturn(null);

        ResponseEntity<User> actual = controller.getUser(id);

        assertEquals(expected, actual);
    }

    @Test
    public void testGetUsers() {
        ResponseEntity<Iterable<User>> expected = new ResponseEntity<>(null, HttpStatus.OK);
        when(mockService.findAll()).thenReturn(null);

        ResponseEntity<Iterable<User>> actual = controller.getUsers();

        assertEquals(expected, actual);
    }

    @Test
    public void testCreateUser() {
        User user = null;
        ResponseEntity<User> expected = new ResponseEntity<>(null, HttpStatus.CREATED);
        when(mockService.create(null)).thenReturn(null);

        ResponseEntity<User> actual = controller.createUser(user);

        assertEquals(expected, actual);
    }

    @Test
    public void testLogin() {
        User user = null;
        ResponseEntity<User> expected = new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        when(mockService.findUserByUsername("username")).thenReturn(null);

        ResponseEntity<User> actual = controller.login(user);

        assertEquals(expected, actual);
    }

    @Test
    public void testGetUsersByProfileType() {
        String type = "type";
        ResponseEntity<Iterable<User>> expected = new ResponseEntity<>(null, HttpStatus.OK);
        when(mockService.findAll()).thenReturn(null);

        ResponseEntity<Iterable<User>> actual = controller.getUsersByProfileType(type);

        assertEquals(expected, actual);
    }
}
