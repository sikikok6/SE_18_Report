package com.example.demo.Dao;


import lombok.Data;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity

public class BasicInfoDao {
    @Id
    private String Openid;
    private String Comid;
    private String Name;
    private Integer Sex;
    private String Tel;

}
