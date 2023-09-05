package com.zm.mapper;

import com.zm.pojo.TDept;
import com.zm.pojo.TEmp;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TEmpMapper {

    //查询
    List<TEmp> queryAll();

    //删除
    @Delete("delete from t_emp where emp_id = #{empId}")
    int delTemp(@Param("empId") int empId);

    //添加
    @Insert("insert into t_emp(emp_no,emp_name,emp_dept_id,emp_sex,emp_education,emp_email,emp_phone) values(#{empNo},#{empName},#{empDeptId},#{empSex},#{empEducation},#{empEmail},#{empPhone})")
    int addTemp(TEmp tEmp);

    //根据empId查询
    List<TEmp> selectByEmpId(@Param("empId") int empId);

    //修改
    @Update("update t_emp set emp_no=${empNo},emp_name=#{empName},emp_dept_id=#{empDeptId},emp_sex=#{empSex},emp_education=#{empEducation},emp_email=#{empEmail},emp_phone=#{empPhone} where emp_id=${empId}")
    int upEmp(TEmp tEmp);
}
