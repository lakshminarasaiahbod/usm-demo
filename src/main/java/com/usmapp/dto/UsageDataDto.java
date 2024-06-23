package com.usmapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UsageDataDto {

    private String id;
    private String mdn;
    private Date usageDate;
    private Number usedInMb;
    private UserDataDto userDataDto;

}
