package com.usmapp.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Data
@Document(collection = "UserData")
public class UserData {
	
    @Id
    private String id;

    @Field("firstName")
    private String firstName;

    @Field("lastName")
    private String lastName;

    @Field("email")
    private String email;

    @Field("password")
    private String password;

    @Field("createdAt")
    private Date createdAt;

    @Field("lastLoggedIn")
    private Date lastLoggedIn;

    @Field("authKey")
    private String authKey;

    @Field("activeUser")
    private Boolean activeUser;

}

