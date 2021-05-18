package com.example.demo.Service;


import com.example.demo.Dao.BasicInfoDao;
import com.example.demo.Dao.BasicInfoRepository;
import com.example.demo.Dao.MessageDao;
import com.example.demo.Dao.MessageRepository;
import com.example.demo.Response.UserCodeVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class UserCodeServiceImpl implements UserCodeService{

    @Resource
    private MessageRepository messageRepository;

    @Override
    public UserCodeVO GetState(String OpenId){
        Optional<MessageDao> messageDaoOptional = messageRepository.findById(OpenId);

        int State = -1;

        MessageDao messageDao = new MessageDao();

        if(messageDaoOptional.isPresent()){
            System.out.println("UserCode:User Is Present;");
            messageDao = messageDaoOptional.get();
            if(messageDao.getHealthcondition()+messageDao.getRiskcontact()+messageDao.getRisklocation()>0){
                State = 1;
                return UserCodeVO.builder().State(State).Msg("UserCode:State Dangerous").build();
            }else{
                State = 0;
                return UserCodeVO.builder().State(State).Msg("UserCode:State Ok").build();
            }
        }else{
            System.out.println("UserCode:Bad OpenId;");

            return UserCodeVO.builder().State(State).Msg("UserCode:Bad OpenId").build();
        }

    }
}
