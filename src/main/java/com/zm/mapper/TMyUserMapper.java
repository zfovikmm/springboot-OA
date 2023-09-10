package com.zm.mapper;

import com.zm.pojo.TMyUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;


@Mapper
public interface TMyUserMapper {
    //登录
    @Select("select * from oa.t_my_user where my_account =#{myAccount} and my_pwd = #{myPwd}")
    Integer login(@Param("myAccount") String myAccount, @Param("myPwd")String myPwd);

    //认证登录
    @Select("select * from oa.t_my_user where my_account =#{myAccount}")
    TMyUser queryUserName(@Param("myAccount") String myAccount);


}
