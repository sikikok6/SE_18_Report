package com.example.demo.Service;

import com.example.demo.Dao.AbnormalDao;
import com.example.demo.Dao.AbnormalRepository;
import com.example.demo.Dao.MessageDao;
import com.example.demo.Dao.MessageRepository;
import com.example.demo.Model.Message;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class MessageServiceImpl implements MessageService{
    @Resource
    private MessageRepository messageRepository;
    @Resource
    private AbnormalRepository abnormalRepository;

    @Override
    public String MessageReport(Message message) throws IllegalAccessException {


        MessageDao messageDao = new MessageDao();

        messageDao.setOpenid(message.getOpenid());
        messageDao.setHealthcondition(message.getHealthcondition());
        messageDao.setRisklocation(message.getRisklocation());
        messageDao.setRiskcontact(message.getRiskcontact());
        messageDao.setLocation(message.getLocation());
        messageDao.setTime(message.getTime());

        messageRepository.save(messageDao);

        if(message.getHealthcondition() == 1 || message.getRisklocation() == 1 || message.getRiskcontact() == 1)
        {
            AbnormalDao abnormalDao = new AbnormalDao();
            System.out.println(message);
            Class clazz = abnormalDao.getClass();
            Field[] fields = clazz.getDeclaredFields();
            Class clazzm = message.getClass();
            Field[] fieldm = clazzm.getDeclaredFields();
            for(Field a:fields){
                for(Field m:fieldm){
                    if(a.getName().equals(m.getName())){
                        a.setAccessible(true);
                        m.setAccessible(true);
                        a.set(abnormalDao,m.get(message));
//                        System.out.println(m.getName());
//                        System.out.println(m.get(message));
//                        System.out.println(a.get(abnormalDao));
                    }
                }
            }
            System.out.println(abnormalDao);
//            abnormalDao.setOpenid(message.getOpenid());
//            abnormalDao.setHealthcondition(message.getHealthcondition());
//            abnormalDao.setTemperature(message.getTemperature());
//            abnormalDao.setSymptom(message.getSymptom());
            abnormalRepository.save(abnormalDao);

        }
        return  "Successful Update To DB";
    }

}
