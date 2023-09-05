package com.zm.controller;

import com.zm.mapper.TDeptMapper;
import com.zm.mapper.TEmpMapper;
import com.zm.pojo.TDept;
import com.zm.pojo.TEmp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class TempController {
    @Autowired
    private TEmpMapper tEmpMapper;

    @Autowired
    private TDeptMapper tDeptMapper;

    //查询
    @RequestMapping("queryAllTemp")
    public String queryAllTemp(Model model){
        List<TEmp> tEmpMappers = tEmpMapper.queryAll();
        model.addAttribute("tEmpMappers",tEmpMappers);
        return "emp/temp";
    }

    //删除
    @RequestMapping("delTemp")
    public String delTemp(int empId,Model model){
        tEmpMapper.delTemp(empId);
        List<TEmp> tEmpMappers = tEmpMapper.queryAll();
        model.addAttribute("tEmpMappers",tEmpMappers);
        return "emp/temp";
    }

    //toAddTemp
    @RequestMapping("toAddTemp")
    public String toAddTemp(Model model){
        List<TDept> tDepts = tDeptMapper.queryAllDept();
        model.addAttribute("departments",tDepts);
        return "emp/tempAdd";
    }

    //添加
    @RequestMapping("addTemp")
    public String addTemp(TEmp tEmp,Model model){
        tEmpMapper.addTemp(tEmp);
        List<TEmp> tEmpMappers = tEmpMapper.queryAll();
        model.addAttribute("tEmpMappers",tEmpMappers);
        return "emp/temp";
    }

    //toUpDept
    @RequestMapping("toUpEmp")
    public String toUpEmp(int empId,Model model){
        //获取要修改员工的信息
        List<TEmp> tEmps = tEmpMapper.selectByEmpId(empId);
        model.addAttribute("tEmps",tEmps);

        return "emp/tempEdit";
    }

    @RequestMapping("upEmp")
    public String upEmp(TEmp tEmp,Model model){
        tEmpMapper.upEmp(tEmp);
        List<TEmp> tEmpMappers = tEmpMapper.queryAll();
        model.addAttribute("tEmpMappers",tEmpMappers);
        return "emp/temp";
    }
}
