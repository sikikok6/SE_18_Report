package com.example.demo.Model;

import lombok.Data;

@Data
public class Abnormal {
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
}
