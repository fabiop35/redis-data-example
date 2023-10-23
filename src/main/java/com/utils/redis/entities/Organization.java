package com.utils.redis.entities;

//import javax.persistence.Id;
import java.io.Serializable;

import  org.springframework.data.redis.core.RedisHash;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RedisHash("organization")
public class Organization implements Serializable {
    
    //@Id
    String id;
    String name;
    String contactName;
    String contactEmail;
    String contactPhone;

}
