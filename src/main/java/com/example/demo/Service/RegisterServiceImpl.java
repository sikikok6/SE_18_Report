package com.example.demo.Service;

import com.example.demo.Dao.BasicInfoDao;
import com.example.demo.Dao.BasicInfoRepository;
import com.example.demo.Model.BasicInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RegisterServiceImpl implements RegisterService{

    @Resource
    private BasicInfoRepository basicInfoRepository;

    @Override
    public String Register(BasicInfo basicInfo){


        BasicInfoDao basicInfoDao = new BasicInfoDao();


        basicInfoDao.setOpenid(basicInfo.getOpenid());
        basicInfoDao.setComid(basicInfo.getComid());
        basicInfoDao.setName(basicInfo.getName());
        basicInfoDao.setSex(basicInfo.getSex());
        basicInfoDao.setTel(basicInfo.getTel());



        basicInfoRepository.save(basicInfoDao);



        return "Successful To DB";
    }



}
