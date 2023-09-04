package com.zm.service;

import com.zm.mapper.TMyUserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

public class TMyUserServiceImpl implements TMyUserService{
    @Resource
    TMyUserMapper tMyUserMapper;

    @Override
    public Integer login(String myAccount, String myPwd) {
        return tMyUserMapper.login(myAccount,myPwd);
    }
}
