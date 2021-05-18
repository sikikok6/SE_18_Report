package com.example.demo.Controller;


import com.alibaba.fastjson.JSONObject;
import com.example.demo.Model.BasicInfo_Front;
import com.example.demo.Response.LoginVO;
import com.example.demo.Model.Login;
import com.example.demo.Service.LoginService;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Objects;

@RestController
@RequestMapping("/Login")
public class WxLoginController {

    @Resource
    LoginService loginService;

    @PostMapping
    public LoginVO login(@RequestBody Login login) throws IOException {
    //@RequestBody LoginBO类名 loginBO实例    @RequestBody DTO dto   DTO-DataTransferObject
        System.out.println(login);

        BasicInfo_Front basicInfo_front = new BasicInfo_Front();

        if(login.getCode()==null){
            return LoginVO.builder().
                    code("").
                    status(-1).
                    msg("Failed To Accept Code").
                    basicInfo_front(basicInfo_front).
                    build();
        }

        String OpenId = GetOpenID(login.getCode());
        if(OpenId==null){
            return LoginVO.builder().
                    code("").
                    status(0).
                    msg("Failed To Get OpenId").
                    basicInfo_front(basicInfo_front).
                    build();
        }

        basicInfo_front = loginService.GetBasicInfo_Front(OpenId);

        return  LoginVO.builder().
                code("200").
                status(1).
                msg("Success To Get OpenId").
                basicInfo_front(basicInfo_front).
                build();

    }

    public String GenerateTargetURL(String Code){
        String APPID  = "?appid=wx7b3c6e8f013cf896";
        String SECRET = "&secret=77f8ccbde898a58ac373e2ba71ad2cc1";
        String CODE   = "&js_code=" + Code;
        String Head   = "https://api.weixin.qq.com/sns/jscode2session";
        String Tail   = "&grant_type=authorization_code";
        return Head + APPID + SECRET + CODE + Tail;
    }

    public String GetOpenID(String Code) throws IOException {
        String OpenID = "";

        String URL = GenerateTargetURL(Code);
        OkHttpClient client = new OkHttpClient();
        Request request     = new Request.Builder().url(URL).build();
        Response response   = client.newCall(request).execute();//省略了捕获异常

        if(response.isSuccessful()){
            String body = Objects.requireNonNull(response.body()).string();
            JSONObject jsonObject = JSONObject.parseObject(body);
            OpenID = jsonObject.getString("openid");

            System.out.println(OpenID);
        }
        return OpenID;
    }

}
