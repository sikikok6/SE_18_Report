package com.example.demo.Model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.AllArgsConstructor;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

@Data
public class ApplyModel {
    private String Openid;
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
    private int Permit=-1;
}
