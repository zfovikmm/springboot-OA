package com.zm.mapper;

import com.zm.pojo.TEmp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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
}
