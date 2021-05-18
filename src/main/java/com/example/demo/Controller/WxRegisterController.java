package com.example.demo.Controller;


import com.example.demo.Dao.BasicInfoDao;
import com.example.demo.Dao.BasicInfoRepository;
import com.example.demo.Model.BasicInfo;
import com.example.demo.Response.RegisterVO;
import com.example.demo.Service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/Register")
public class WxRegisterController {
    @Resource
    RegisterService registerService;

    @PostMapping
    public RegisterVO registerVO (@RequestBody BasicInfo basicInfo){


        System.out.println(basicInfo);

        System.out.println(basicInfo.getComid());

        String msg  = registerService.Register(basicInfo);


        return RegisterVO.builder().status(1).code("200").msg(msg).build();
    }


}
