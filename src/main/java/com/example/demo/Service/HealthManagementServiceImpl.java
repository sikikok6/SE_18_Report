package com.example.demo.Service;

import com.example.demo.Dao.AbnormalDao;
import com.example.demo.Dao.AbnormalRepository;
import com.example.demo.Dao.BasicInfoRepository;

import com.example.demo.Model.Abnormal;
import com.example.demo.Model.AllInfo;

import com.example.demo.Response.AbnormalVO;
import com.example.demo.Response.HealthManagementVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;


@Service
public class HealthManagementServiceImpl implements HealthManagementService {
    @Resource
    private BasicInfoRepository basicInfoRepository;
    @Resource
    private AbnormalRepository abnormalRepository;

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

    @Override
    public AbnormalVO GetAbnormal(String Openid){
        System.out.println("GetAbnormal: Opendid"+Openid);

        String msg = "";
        Abnormal abnormal = new Abnormal();
        Optional<AbnormalDao> abnormalDaoOptional = abnormalRepository.findById(Openid);
        if(!abnormalDaoOptional.isPresent()){
            msg ="GetAbnormal:Can't Find AbnormalDao";
        }else {
            AbnormalDao abnormalDao = abnormalDaoOptional.get();

            abnormal.setHealthcondition(abnormalDao.getHealthcondition());
            abnormal.setTemperature(abnormalDao.getTemperature());
            abnormal.setSymptom(abnormalDao.getSymptom());
            abnormal.setIsolation(abnormalDao.getIsolation());

            abnormal.setRisklocation(abnormalDao.getRisklocation());
            abnormal.setTodaylocation(abnormalDao.getTodaylocation());
            abnormal.setFourteenlocation(abnormalDao.getFourteenlocation());

            abnormal.setRiskcontact(abnormalDao.getRiskcontact());
            abnormal.setPeoplecontact(abnormalDao.getPeoplecontact());
            abnormal.setCommunitycontact(abnormalDao.getCommunitycontact());

            msg = "GetAbnormal:Success Get AbnormalDao";
        }
        return AbnormalVO.builder().msg(msg).abnormal(abnormal).build();
    }


}

