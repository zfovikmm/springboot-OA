package com.zm.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {


    //ShiroFilterFactoryBean
    //@Qualifier("securityManager")注解表示该方法将注入名为securityManager的Bean作为参数。
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置安全管理器   使用bean.setSecurityManager(defaultWebSecurityManager)将SecurityManager对象设置为ShiroFilterFactoryBean的安全管理器。
        bean.setSecurityManager(defaultWebSecurityManager);

        //添加shiro的内置过滤器
        /*
        anon：无需认证
        authc：必须认证了才能访问
        perms：拥有对某个资源的权限才能访问
        role：拥有某个角色权限才能访问
         */
        //拦截   创建一个LinkedHashMap类型的filterMap变量，用于存储URL和相应的权限要求。
        Map<String,String> filterMap = new LinkedHashMap<>();
        //跳转到未授权页面
//        filterMap.put("/user/add","perms[user:add]");
//        filterMap.put("/user/update","perms[user:update]");
        filterMap.put("/addDept","perms[dept:add]");
        filterMap.put("/delDept","perms[dept:del]");
        //bean.setFilterChainDefinitionMap(filterMap) 是将过滤器链的定义映射设置为 filterMap。这个方法的作用是配置 Shiro 框架中的 URL 过滤器链。
        //通过这个方法，您可以定义哪些 URL 需要经过身份验证（认证）和授权才能访问。
        //setFilterChainDefinitionMap() 方法的调用将过滤器链定义映射设置到 ShiroFilterFactoryBean 实例中，该实例负责处理 URL 路径与权限之间的映射关系。
        bean.setFilterChainDefinitionMap(filterMap);

        //设置登录请求
        bean.setLoginUrl("/login");

        //未授权页面
        bean.setUnauthorizedUrl("/noauth");



        return bean;
    }

    //DefaultWebSecurityManager
    //在 Shiro 中，SecurityManager 是整个安全框架的核心组件，负责协调各个安全组件的工作。它是 Shiro 的入口点，用于处理身份验证、授权以及与安全相关的操作。
    //@Qualifier("userRealm") 注解来指定依赖注入时使用的 UserRealm Bean。
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        //首先创建了一个 DefaultWebSecurityManager 对象，该对象是 Shiro 提供的默认的 Web 安全管理器。
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();

        // 接着使用 securityManager.setRealm(userRealm) 方法将自定义的 UserRealm 对象与 SecurityManager 关联起来，表示使用该 UserRealm 对象进行身份认证和授权操作。
        //关联UserRealm
        securityManager.setRealm(userRealm);

        //通过 return securityManager 返回创建的 SecurityManager Bean。
        //这样配置好的 SecurityManager Bean 可以在其他地方进行引用和使用，例如可以将其配置到 Shiro 的过滤器链中，用于处理身份验证和授权操作。
        return securityManager;
    }

    //创建 realm 对象 需要自定义
    //Realm 是用于管理用户、角色和权限信息的对象。它负责从数据源获取用户的认证信息和授权信息，并提供给 SecurityManager 进行身份验证和授权操作。
    @Bean(name="userRealm")
    public UserRealm userRealm(){
        return new UserRealm();
    }

    //整合shiroDialect：用来整合thymeleaf
    @Bean
    public ShiroDialect getShiroDialect(){
        return new ShiroDialect();
    }
}
