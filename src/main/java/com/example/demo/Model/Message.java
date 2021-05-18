package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Message {

    private String Openid;
    private Integer Healthcondition;
    private Integer Risklocation;
    private Integer Riskcontact;
    private double Longitude;
    private double Latitude;
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss",timezone = "GMT+8")
    private Date Time;
}
