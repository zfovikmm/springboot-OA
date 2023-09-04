package com.zm.controller;



import com.zm.mapper.TMyUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class userController {
    @Autowired
    TMyUserMapper tMyUserMapper;


    @RequestMapping("login")
    public String login(String myAccount, String myPwd){
        Integer login = tMyUserMapper.login(myAccount,myPwd);
        if (login != null){
            return "main";
        }else {
            return "login";
        }
    }
}
