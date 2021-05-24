package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Message {

    private String Openid;
    private Integer Healthcondition;
    private Integer Temperature = 0;
    private Integer Symptom = 0;
    private Integer Isolation = 0;

    private Integer Risklocation;
    private Integer Todaylocation = 0;
    private Integer Fourteenlocation = 0;

    private Integer Riskcontact;
    private Integer Peoplecontact = 0;
    private Integer Communitycontact = 0;

    private double Longitude;
    private double Latitude;
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss",timezone = "GMT+8")
    private Date Time;
}
