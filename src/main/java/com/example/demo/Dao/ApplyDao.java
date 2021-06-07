package com.example.demo.Dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ApplyDao {
    @EmbeddedId
    ApplyID ids;

    private String Location;
    private Date Time;
    private int Type;
    private int Reason;
    private Date Starttime;
    private Date Endtime;
    private String Schedule;
    private String Traffictools;
    private String Destination;
    private int Permit;

}
