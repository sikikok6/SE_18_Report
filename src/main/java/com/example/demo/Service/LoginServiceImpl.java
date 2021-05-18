package com.example.demo.Service;

import com.example.demo.Dao.BasicInfoDao;
import com.example.demo.Dao.BasicInfoRepository;
import com.example.demo.Model.BasicInfo_Front;
import com.example.demo.Model.Login;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    private BasicInfoRepository basicInfoRepository;


    @Override
    public String GetCode(Login login) {
        return login.getCode();
    }

    @Override
    public BasicInfo_Front GetBasicInfo_Front(String OpenId) {

        Optional<BasicInfoDao> basicInfoDaoOptional = basicInfoRepository.findById(OpenId);

        int Jump = -1;
        BasicInfoDao basicInfoDao = new BasicInfoDao();

        if(basicInfoDaoOptional.isPresent()){
            System.out.println("Login:User Is Present");
            basicInfoDao = basicInfoDaoOptional.get();
            Jump = 1;
        }else{
            System.out.println("Login:Nothing");
            Jump = 0;
        }
        System.out.println(basicInfoDao.getComid());

        BasicInfo_Front basicInfo_front = new BasicInfo_Front();
        basicInfo_front.setOpenId(OpenId);
        basicInfo_front.setComId(basicInfoDao.getComid());
        basicInfo_front.setName(basicInfoDao.getName());
        basicInfo_front.setJump(Jump);


        return basicInfo_front;
    }
}
