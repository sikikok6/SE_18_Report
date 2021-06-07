package com.example.demo.Service;


import com.example.demo.Dao.*;
import com.example.demo.Response.UserCodeVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class UserCodeServiceImpl implements UserCodeService{

    @Resource
    private MessageRepository messageRepository;

    @Resource
    private ApplyRepository applyRepository;

    @Override
    public UserCodeVO GetState(String OpenId){
        Optional<MessageDao> messageDaoOptional = messageRepository.findById(OpenId);

        int State = -2;

        MessageDao messageDao = new MessageDao();

        if(messageDaoOptional.isPresent()){
            System.out.println("UserCode:User Is Present;");
            messageDao = messageDaoOptional.get();
            if(messageDao.getHealthcondition()+messageDao.getRiskcontact()+messageDao.getRisklocation()>0){
                State = -1;
                return UserCodeVO.builder().State(State).Msg("UserCode:State Dangerous").build();
            }else{
                //No Apply
                if(applyRepository.CountSeq(OpenId)==null){
                    State = 1;
                }else{
                    int Seq = applyRepository.CountSeq(OpenId);
                    ApplyID applyID = new ApplyID(OpenId,Seq);
                    Optional<ApplyDao> applyDaoOptional = applyRepository.findById(applyID);

                    if (!applyDaoOptional.isPresent()){
                        System.out.println("Error:QRcode Can't Find");
                    }else {
                        ApplyDao applyDao = applyDaoOptional.get();
                        if(applyDao.getPermit()!=1){
                            State = 0;
                        }else {
                            State =1;
                        }
                    }

                }

                return UserCodeVO.builder().State(State).Msg("UserCode:State Ok").build();
            }
        }else{
            System.out.println("UserCode:Bad OpenId;");

            return UserCodeVO.builder().State(State).Msg("UserCode:Bad OpenId").build();
        }

    }
}
