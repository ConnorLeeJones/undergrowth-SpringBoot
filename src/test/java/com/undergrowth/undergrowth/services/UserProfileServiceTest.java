package com.undergrowth.undergrowth.services;

import com.undergrowth.undergrowth.models.UserProfile;
import com.undergrowth.undergrowth.repositories.UserProfileRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class UserProfileServiceTest {

    @Mock
    private UserProfileRepository mockRepository;

    private UserProfileService userProfileServiceUnderTest;

    @Before
    public void setUp() {
        initMocks(this);
        userProfileServiceUnderTest = new UserProfileService(mockRepository);
    }

    @Test
    public void testFindAll() {
        Iterable<UserProfile> expectedResult = null;
        when(mockRepository.findAll()).thenReturn(null);

        Iterable<UserProfile> result = userProfileServiceUnderTest.findAll();

        assertEquals(expectedResult, result);
    }

    @Test
    public void testFindUserProfileById() {
//        Long id = 0L;
        UserProfile expectedResult = new UserProfile();
        when(mockRepository.findById(1L)).thenReturn(Optional.of(expectedResult));

        UserProfile result = userProfileServiceUnderTest.findUserProfileById(1L);

        assertEquals(expectedResult, result);
    }

    @Test
    public void testCreate() {
        UserProfile profile = new UserProfile();
        UserProfile expectedResult = null;
        when(mockRepository.save(null)).thenReturn(null);

        UserProfile result = userProfileServiceUnderTest.create(profile);

        assertEquals(expectedResult, result);
    }

    @Test
    public void testUpdate() {
        Long id = 0L;
        UserProfile profile = new UserProfile();
        when(mockRepository.findById(id)).thenReturn(Optional.of(profile));
        when(mockRepository.save(profile)).thenReturn(profile);

        UserProfile result = userProfileServiceUnderTest.update(id, profile);

        assertEquals(profile, result);
    }

    @Test
    public void testFindUserProfilesByType() {
        String type = "type";
        Iterable<UserProfile> expectedResult = null;
        when(mockRepository.findUserProfilesByType("type")).thenReturn(null);

        Iterable<UserProfile> result = userProfileServiceUnderTest.findUserProfilesByType(type);

        assertEquals(expectedResult, result);
    }
}
