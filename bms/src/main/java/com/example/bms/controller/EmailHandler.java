package com.example.bms.controller;

import com.example.bms.mapper.EmailMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/email")
public class EmailHandler {

    private final JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String account;

    @Autowired
    private EmailMapper emailMapper;

    @RequestMapping("/sendEmail")
    public int sendEmail(@RequestBody Map<String,String> param){

        SimpleMailMessage smm = new SimpleMailMessage();
        smm.setFrom(account);
        smm.setTo(param.get("address"));
        smm.setSubject("感谢您的反馈！");
        smm.setText("非常感谢您的反馈我们会尽最大的努力改进这方面的问题，也希望您能一如既往地支持和监督我们的工作，谢谢！");
        javaMailSender.send(smm);

        return emailMapper.addEmail(param);
    }
}
