package com.example.demo.Service;

import com.example.demo.Dao.MessageDao;
import com.example.demo.Dao.MessageRepository;
import com.example.demo.Model.Message;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MessageServiceImpl implements MessageService{
    @Resource
    private MessageRepository messageRepository;

    @Override
    public String MessageReport(Message message){


        MessageDao messageDao = new MessageDao();

        messageDao.setOpenid(message.getOpenid());
        messageDao.setHealthcondition(message.getHealthcondition());
        messageDao.setRisklocation(message.getRisklocation());
        messageDao.setRiskcontact(message.getRiskcontact());
        messageDao.setLongitude(message.getLongitude());
        messageDao.setLatitude(message.getLatitude());
        messageDao.setTime(message.getTime());

        messageRepository.save(messageDao);






        return  "Successful Update To DB";
    }

}
