package com.zm.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

@Service
public interface TMyUserService {


    Integer login(String myAccount,String myPwd);
}
