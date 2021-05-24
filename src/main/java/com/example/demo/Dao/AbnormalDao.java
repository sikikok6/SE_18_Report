package com.example.demo.Dao;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class AbnormalDao {
    @Id
    private String Openid;

    private Integer Healthcondition;
    private Integer Temperature;
    private Integer Symptom ;
    private Integer Isolation ;

    private Integer Risklocation;
    private Integer Todaylocation;
    private Integer Fourteenlocation;

    private Integer Riskcontact;
    private Integer Peoplecontact;
    private Integer Communitycontact;

    private double Longitude;
    private double Latitude;
    private Date Time;
}
