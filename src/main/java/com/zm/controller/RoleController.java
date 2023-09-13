package com.zm.controller;

import com.zm.mapper.RoleMapper;
import com.zm.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;

@Controller
public class RoleController {

    @Autowired
    private RoleMapper roleMapper;

    @RequestMapping("queryAllRole")
    public String queryAllRole(Model model){
        HashMap<Object, Object> hashMap = new HashMap<>();
        List<Role> roles = roleMapper.queryAllRole();
        System.out.println(roles);
        hashMap.put("roles",roles);
        System.out.println(hashMap);
        model.addAttribute("roles",roles);
        return "role/role";
    }
}
