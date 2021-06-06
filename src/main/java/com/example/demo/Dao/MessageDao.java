package com.example.demo.Dao;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class MessageDao {
    @Id
    private String Openid;
    private Integer Healthcondition;
    private Integer Risklocation;
    private Integer Riskcontact;
    private String Location;
    private Date Time;

}
