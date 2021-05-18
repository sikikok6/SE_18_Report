package com.example.demo.Service;

import com.example.demo.Model.BasicInfo_Front;
import com.example.demo.Model.Login;

public interface LoginService {
    public String GetCode(Login login);



    public BasicInfo_Front GetBasicInfo_Front(String OpenId);


}
