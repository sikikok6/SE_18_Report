package com.example.demo.Controller;


import com.example.demo.Response.UserCodeVO;
import com.example.demo.Service.UserCodeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class WxUserCodeController {
    @Resource
    UserCodeService userCodeService;

    @GetMapping("/findById")
    public UserCodeVO userCodeVO(@RequestParam("Openid") String Openid){

        return userCodeService.GetState(Openid);
    }

}
