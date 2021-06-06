package com.example.demo.Service;

import com.example.demo.Dao.BasicInfoRepository;

import com.example.demo.Model.AllInfo;

import com.example.demo.Response.HealthManagementVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;


@Service
public class HealthManagementServiceImpl implements HealthManagementService {
    @Resource
    private BasicInfoRepository basicInfoRepository;
    @Override
    public HealthManagementVO GetAll() {
       String msg="";
        List<Object[]> Test = basicInfoRepository.findPL();
        List<AllInfo> allInfos = new ArrayList<>();
        for (Object[] objects : Test) {
            AllInfo info = new AllInfo();
            Object[] object = objects;
            info.setOpenid((String) object[0]);
            info.setComid((String) object[1]);
            info.setName((String) object[2]);
            info.setSex((Boolean) object[3] ? 1 : 0);
            info.setTel((String) object[4]);
            info.setHealthcondition((Boolean) object[5] ? 1 : 0);
            info.setRiskcontact((Boolean) object[6] ? 1 : 0);
            info.setRisklocation((Boolean) object[7] ? 1 : 0);
            info.setLocation((String) object[8]);
            info.setTime((Date) object[9]);
            allInfos.add(info);
        }

        return HealthManagementVO.builder().status(1).code("200").msg(msg).all(allInfos).build();
    }


}

