package com.zm.config;

import com.zm.mapper.TMyUserMapper;
import com.zm.pojo.TMyUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    TMyUserMapper tMyUserMapper;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //SimpleAuthorizationInfo是Shiro提供的一个授权信息的实现类。它用于存储用户的角色和权限信息。
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Subject subject = SecurityUtils.getSubject();
        TMyUser currentUser = (TMyUser) subject.getPrincipal();
        info.addStringPermission("dept:add");

        return info;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //UsernamePasswordToken是Shiro提供的一个实现类，用于封装用户的用户名和密码信息。
        //将login接口创建的token对象转换为UsernamePasswordToken类型，并将其赋值给userToken变量。这行代码的目的是为了在后续的认证过程中使用userToken变量来访问和操作UsernamePasswordToken对象
        UsernamePasswordToken userToken = (UsernamePasswordToken) token;

        //链接真实数据库
        TMyUser tMyUser = tMyUserMapper.queryUserName(userToken.getUsername());

        if(tMyUser == null){
            return null;
        }
        return new SimpleAuthenticationInfo(tMyUser,tMyUser.getMyPwd(),"");
    }
}
