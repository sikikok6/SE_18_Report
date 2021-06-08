package com.example.demo.Controller;


import com.example.demo.Response.AbnormalVO;
import com.example.demo.Response.HealthManagementVO;

import com.example.demo.Service.HealthManagementService;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class WxHealthManagementController {
    @Resource HealthManagementService healthManagementService;


    @GetMapping("/GetHealth")
    public HealthManagementVO Findall(){
        return healthManagementService.GetAll();
    }

    @GetMapping("/GetRisk")
    public AbnormalVO GetAbnormal(@RequestParam("Openid") String Openid){
        return healthManagementService.GetAbnormal(Openid);
    }
}
