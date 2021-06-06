package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class AllInfo {
    private String Openid;
    private String Comid;
    private String Name;
    private Integer Sex;
    private String Tel;
    private Integer Healthcondition;
    private Integer Risklocation;
    private Integer Riskcontact;
    private String Location;
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss",timezone = "GMT+8")
    private Date Time;
}
