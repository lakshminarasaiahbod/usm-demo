package com.usmapp.controllers;

import com.usmapp.controller.UserController;
import com.usmapp.entity.UserData;
import com.usmapp.service.UserDataService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class UserControllerTest {

    @Mock
    private UserDataService userDataService;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateUser() {
        UserData mockUserData = new UserData();
        mockUserData.setId(String.valueOf(1L));
        mockUserData.setFirstName("Test User");

        when(userDataService.createUser(any(UserData.class))).thenReturn(mockUserData);

        UserData userDataDto = new UserData();
        userDataDto.setFirstName("Test User");

        ResponseEntity<UserData> responseEntity = userController.create(userDataDto);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(mockUserData, responseEntity.getBody());
    }

    @Test
    void testCreateUser_InternalServerError() {
        when(userDataService.createUser(any(UserData.class))).thenThrow(new RuntimeException("Exception"));

        UserData userDataDto = new UserData();
        userDataDto.setFirstName("Test User");

        ResponseEntity<UserData> responseEntity = userController.create(userDataDto);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
        assertEquals(null, responseEntity.getBody());
    }

    @Test
    void testUpdateUser() {
        UserData mockUserData = new UserData();
        mockUserData.setId(String.valueOf(1L));
        mockUserData.setFirstName("Updated User");

        when(userDataService.updateUser(any(UserData.class))).thenReturn(mockUserData);

        UserData userDataDto = new UserData();
        userDataDto.setFirstName("Updated User");

        ResponseEntity<UserData> responseEntity = userController.update(userDataDto);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(mockUserData, responseEntity.getBody());
    }

    @Test
    void testUpdateUser_InternalServerError() {
        when(userDataService.updateUser(any(UserData.class))).thenThrow(new RuntimeException("Exception"));

        UserData userDataDto = new UserData();
        userDataDto.setFirstName("Updated User");

        ResponseEntity<UserData> responseEntity = userController.update(userDataDto);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
        assertEquals(null, responseEntity.getBody());
    }
}
