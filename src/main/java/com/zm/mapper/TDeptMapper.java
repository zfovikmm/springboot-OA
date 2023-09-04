package com.zm.mapper;

import com.zm.pojo.TDept;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TDeptMapper {


    //删除
    @Delete("delete from t_dept where dept_id = #{deptId}")
    int delDept(@Param("deptId") int deptId);

    //查询
    List<TDept> queryAllDept();

    //添加
    @Insert("insert into t_dept(dept_no,dept_name,dept_location,dept_pid) values(#{deptNo},#{deptName},#{deptLocation},#{deptPid})")
    int addDept(TDept tDept);

    //修改
    @Update("update t_dept set dept_no=${deptNo},dept_name=#{deptName},dept_location=#{deptLocation},dept_pid=#{deptPid} where dept_id=${deptId}")
    int upDept(TDept tDept);

    //根据id查询
    List<TDept> selectDept(@Param("deptId") int deptId);

    //查询 部门编号和部门名字
    List<TDept> selectByDeptName();
}
