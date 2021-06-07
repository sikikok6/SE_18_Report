package com.example.demo.Service;

import com.example.demo.Dao.ApplyDao;
import com.example.demo.Dao.ApplyID;
import com.example.demo.Dao.ApplyRepository;
import com.example.demo.Dao.BasicInfoDao;
import com.example.demo.Model.AllApplyInfo;
import com.example.demo.Model.ApplyModel;
import com.example.demo.Model.Permission;
import com.example.demo.Response.ApplyVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLOutput;
import java.util.*;

@Service
public class ApplyServiceImpl implements ApplyService {

    @Resource
    private ApplyRepository applyRepository;

    @Override
    public String AddApplication(ApplyModel applyModel) {

        String Openid = applyModel.getOpenid();
        Integer Seq =-1;
        if(applyRepository.CountSeq(Openid)==null){
            Seq = 1;
        }else{
            Seq = applyRepository.CountSeq(Openid) + 1;
        }

        ApplyID applyID = new ApplyID(Openid,Seq);

        ApplyDao applyDao = new ApplyDao();

        applyDao.setIds(applyID);

        applyDao.setType(applyModel.getType());
        applyDao.setReason(applyModel.getReason());
        applyDao.setStarttime(applyModel.getStarttime());
        applyDao.setEndtime(applyModel.getEndtime());
        applyDao.setLocation(applyModel.getLocation());

        applyDao.setTime(applyModel.getTime());
        applyDao.setSchedule(applyModel.getSchedule());
        applyDao.setTraffictools(applyModel.getTraffictools());
        applyDao.setDestination(applyModel.getDestination());
        applyDao.setPermit(applyModel.getPermit());

        applyRepository.save(applyDao);

        return "Successful add leave info To DB";
    }

    @Override
    public ApplyVO GetApplications(){
        List<Object[]> ApplyInfos = applyRepository.GetApplyInfo();
        System.out.println(ApplyInfos.size());
        List<AllApplyInfo>  allApplyInfos= new ArrayList<>();

        for (Object[] objects : ApplyInfos) {

            System.out.println(Arrays.toString(objects));

            AllApplyInfo applyInfo = new AllApplyInfo();

            applyInfo.setOpenid((String) objects[0]);
            applyInfo.setComid((String) objects[1]);
            applyInfo.setName((String) objects[2]);
            applyInfo.setSex((Boolean) objects[3] ? 1 : 0);
            applyInfo.setTel((String) objects[4]);
            applyInfo.setSeq((int) objects[5]);
            applyInfo.setLocation((String) objects[6]);
            applyInfo.setTime((Date)objects[7]);
            applyInfo.setType((int) objects[8]);
            applyInfo.setReason((int) objects[9]);
            applyInfo.setStarttime((Date) objects[10]);
            applyInfo.setEndtime((Date) objects[11]);
            applyInfo.setSchedule((String) objects[12]);
            applyInfo.setTraffictools((String) objects[13]);
            applyInfo.setDestination((String) objects[14]);
            applyInfo.setPermit((int) objects[15]);

            allApplyInfos.add(applyInfo);
        }

        return ApplyVO.builder().msg("TODO").status(1).code("200").allApplyInfos(allApplyInfos).build();
    }

    @Override
    public ApplyVO GetMyApply(String Openid){

        List<Object[]> ApplyInfos =applyRepository.GetMyApplyInfo(Openid);

        System.out.println(ApplyInfos.size());

        List<AllApplyInfo>  myApplyInfos= new ArrayList<>();

        for (Object[] objects : ApplyInfos) {

            System.out.println(Arrays.toString(objects));

            AllApplyInfo applyInfo = new AllApplyInfo();

            applyInfo.setOpenid((String) objects[0]);
            applyInfo.setComid((String) objects[1]);
            applyInfo.setName((String) objects[2]);
            applyInfo.setSex((Boolean) objects[3] ? 1 : 0);
            applyInfo.setTel((String) objects[4]);
            applyInfo.setSeq((int) objects[5]);
            applyInfo.setLocation((String) objects[6]);
            applyInfo.setTime((Date)objects[7]);
            applyInfo.setType((int) objects[8]);
            applyInfo.setReason((int) objects[9]);
            applyInfo.setStarttime((Date) objects[10]);
            applyInfo.setEndtime((Date) objects[11]);
            applyInfo.setSchedule((String) objects[12]);
            applyInfo.setTraffictools((String) objects[13]);
            applyInfo.setDestination((String) objects[14]);
            applyInfo.setPermit((int) objects[15]);

            myApplyInfos.add(applyInfo);
        }

        return ApplyVO.builder().msg("TODO").status(1).code("200").allApplyInfos(myApplyInfos).build();


    }

    @Override
    public String UploadPermission(Permission permission){

        String msg = "";

        String Openid = permission.getOpenid();
        int Seq = permission.getSeq();
        int Permit = permission.getPermit();

        System.out.println(Openid);
        System.out.println(Seq);
        System.out.println(Permit);


        ApplyID applyID = new ApplyID(Openid,Seq);
        Optional<ApplyDao> applyDaoOptional = applyRepository.findById(applyID);

        if (applyDaoOptional.isPresent()){
            ApplyDao applyDao = applyDaoOptional.get();
            applyDao.setPermit(Permit);
            applyRepository.save(applyDao);
            msg = "UploadPermission:Find It And Save Permit";
        }else {
            msg = "Error:Can't find the Application";
        }

        System.out.println(msg);
        return msg;
    }



}
