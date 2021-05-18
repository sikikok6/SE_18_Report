package com.example.demo.Controller;


import com.example.demo.Dao.MessageDao;
import com.example.demo.Dao.MessageRepository;
import com.example.demo.Model.Message;
import com.example.demo.Response.MessageVO;
import com.example.demo.Service.MessageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/Upload")
public class WxMessageController {
    @Resource
    MessageService messageService;


    @PostMapping
    public MessageVO messageVO(@RequestBody Message message){

        System.out.println(message);
        String msg = messageService.MessageReport(message);





        return MessageVO.builder().
                code("200").msg(msg).status(1).
                build();
    }





}
