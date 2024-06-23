package com.usmapp.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.DBRef;
import java.util.Date;

@Data
@Document(collection = "Cycle")
public class CycleData {
	
    @Id
    private String id;

    @Field("mdn")
    private String mdn;

    @Field("startDate")
    private Date startDate;

    @Field("endDate")
    private Date endDate;

    @DBRef
    @Field("userId")
    private UserData userId;
    
}

