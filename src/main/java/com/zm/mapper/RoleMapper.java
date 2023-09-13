package com.zm.mapper;

import com.zm.pojo.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RoleMapper {

    //查询角色id和名称
    //@Select("select * from role")
    List<Role> queryAllRole();

}
