package com.example.demo.Dao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
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

    private String Location;
    private Date Time;
}
