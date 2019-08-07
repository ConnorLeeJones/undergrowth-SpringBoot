package com.undergrowth.undergrowth.controllers;

import com.undergrowth.undergrowth.models.UserProfile;
import com.undergrowth.undergrowth.services.UserProfileService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class UserProfileControllerTest {

    @Mock
    private UserProfileService mockService;

    private UserProfileController controller;

    @Before
    public void setUp() {
        initMocks(this);
        controller = new UserProfileController(mockService);
    }

    @Test
    public void testGetAllProfiles() {
        ResponseEntity<Iterable<UserProfile>> expectedResult = new ResponseEntity<>(null, HttpStatus.OK);
        when(mockService.findAll()).thenReturn(null);

        ResponseEntity<Iterable<UserProfile>> result = controller.getAllProfiles();

        assertEquals(expectedResult, result);
    }

    @Test
    public void testGetUserProfile() {
        Long id = 0L;
        ResponseEntity<UserProfile> expectedResult = new ResponseEntity<>(null, HttpStatus.OK);
        when(mockService.findUserProfileById(0L)).thenReturn(null);

        ResponseEntity<UserProfile> result = controller.getUserProfile(id);

        assertEquals(expectedResult, result);
    }

    @Test
    public void testUpdateUserProfile() {
        Long id = 0L;
        UserProfile profile = null;
        ResponseEntity<UserProfile> expectedResult = new ResponseEntity<>(null, HttpStatus.OK);
        when(mockService.update(0L, null)).thenReturn(null);

        ResponseEntity<UserProfile> result = controller.updateUserProfile(id, profile);

        assertEquals(expectedResult, result);
    }

    @Test
    public void testGetUserProfileByType() {
        String type = "type";
        ResponseEntity<Iterable<UserProfile>> expectedResult = new ResponseEntity<>(null, HttpStatus.OK);
        when(mockService.findUserProfilesByType("type")).thenReturn(null);

        ResponseEntity<Iterable<UserProfile>> result = controller.getUserProfileByType(type);

        assertEquals(expectedResult, result);
    }
}
