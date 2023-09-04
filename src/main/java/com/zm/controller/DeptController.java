package com.zm.controller;

import com.zm.mapper.TDeptMapper;
import com.zm.pojo.TDept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class DeptController {

    @Autowired
    TDeptMapper tDeptMapper;

    //删除
    @RequestMapping("delDept")
    public String delDept(int deptId,Model model){

        int i = tDeptMapper.delDept(deptId);
        if(i != 0){
            List<TDept> tDepts = tDeptMapper.queryAllDept();
            model.addAttribute("tDepts",tDepts);
            return "dept";
        }else {
            List<TDept> tDepts = tDeptMapper.queryAllDept();
            model.addAttribute("tDepts",tDepts);
            return "dept";
        }
    }

    //查询
    @RequestMapping("queryAllDept")
    public String queryAllDept(Model model){
        List<TDept> tDepts = tDeptMapper.queryAllDept();
        model.addAttribute("tDepts",tDepts);
        return "dept";
    }

    //添加
    @RequestMapping("addDept")
    public String addDept(TDept tDept,Model model){
        int i = tDeptMapper.addDept(tDept);
        List<TDept> tDepts = tDeptMapper.queryAllDept();
        model.addAttribute("tDepts",tDepts);
        return "dept";
    }

    //跳转到修改页面
    @RequestMapping("toUpDept")
    public String toUpDept(int deptId,Model model ){
        List<TDept> tDepts = tDeptMapper.selectDept(deptId);
        model.addAttribute("tDepts",tDepts);
        return "deptEdit";
    }

    //修改
    @RequestMapping("upDept")
    public String upDept(TDept tDept,Model model){
        int i = tDeptMapper.upDept(tDept);
        List<TDept> tDepts = tDeptMapper.queryAllDept();
        model.addAttribute("tDepts",tDepts);
        return "dept";
    }
}
