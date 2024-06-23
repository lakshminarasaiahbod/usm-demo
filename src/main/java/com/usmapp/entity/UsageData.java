package com.usmapp.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.DBRef;
import java.util.Date;

@Data
@Document(collection = "UsageData")
public class UsageData {
    @Id
    private String id;

    @Field("mdn")
    private String mdn;

    @DBRef
    @Field("userId")
    private UserData userId;
    
    @Field("cycleId")
    private String cycleId;

    @Field("usageDate")
    private Date usageDate;

    @Field("usedInMb")
    private Number usedInMb;
}
