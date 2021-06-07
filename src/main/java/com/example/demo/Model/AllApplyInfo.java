package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class AllApplyInfo {
    private String Openid;
    private String Comid;
    private String Name;
    private Integer Sex;
    private String Tel;

    private int Seq;
    private String Location;
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss",timezone = "GMT+8")
    private Date Time;
    private int Type;
    private int Reason;
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss",timezone = "GMT+8")
    private Date Starttime;
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss",timezone = "GMT+8")
    private Date Endtime;
    private String Schedule = null;
    private String Traffictools = null;
    private String Destination = null;
    private int Permit;

}
