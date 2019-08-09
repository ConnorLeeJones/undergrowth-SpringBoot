package com.undergrowth.undergrowth.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.MockitoAnnotations.initMocks;

public class UserTest {

    @Mock
    private UserProfile mockUserProfile;

    private User user;

    @Before
    public void setUp() {
        initMocks(this);
        user = new User(1L, "username", "password", "firstName", "lastName", mockUserProfile);
    }

    @Test
    public void getId() {
        Long expected = 1L;
        Long actual = user.getId();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setId() {
        user.setId(2L);

        Long expected = 2L;
        Long actual = user.getId();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getUsername() {
        String expected = "username";
        String actual = user.getUsername();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setUsername() {
        user.setUsername("idk");

        String expected = "idk";
        String actual = user.getUsername();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getPassword() {
        String expected = "password";
        String actual = user.getPassword();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setPassword() {
        user.setPassword("idk");

        String expected = "idk";
        String actual = user.getPassword();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getFirstName() {
        String expected = "firstName";
        String actual = user.getFirstName();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setFirstName() {
        user.setFirstName("idk");

        String expected = "idk";
        String actual = user.getFirstName();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getLastName() {
        String expected = "lastName";
        String actual = user.getLastName();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setLastName() {
        user.setLastName("idk");

        String expected = "idk";
        String actual = user.getLastName();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getUserProfile() {
        UserProfile expected = mockUserProfile;
        UserProfile actual = user.getUserProfile();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setUserProfile() {
        UserProfile newProfile = new UserProfile();

        user.setUserProfile(newProfile);

        UserProfile actual = user.getUserProfile();

        Assert.assertEquals(newProfile, actual);

    }




}
