package com.usmapp.controller;

import com.usmapp.dto.UserDataDto;
import com.usmapp.entity.UserData;
import com.usmapp.service.UserDataService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserDataService userDataService;


    @PostMapping("/user")
    public ResponseEntity<UserData> create(@RequestBody UserData userDataDto) {
        UserData newUser;
        try {
            newUser = userDataService.createUser(userDataDto);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(newUser, HttpStatus.OK);
    };


    @GetMapping("/update")
    public ResponseEntity<UserData> update(@RequestBody UserData userDataDto) {
        UserData userData;
        try {
            userData = userDataService.updateUser(userDataDto);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(userData, HttpStatus.OK);
    };

}
