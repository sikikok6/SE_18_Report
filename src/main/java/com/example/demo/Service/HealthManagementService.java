
package com.example.demo.Service;

import com.example.demo.Model.Abnormal;
import com.example.demo.Model.AllInfo;
import com.example.demo.Response.AbnormalVO;
import com.example.demo.Response.HealthManagementVO;


import java.util.List;

public interface HealthManagementService {
    public HealthManagementVO GetAll();

    public AbnormalVO GetAbnormal(String Openid);
}

