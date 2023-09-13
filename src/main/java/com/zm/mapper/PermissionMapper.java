package com.zm.mapper;

import com.zm.pojo.Permission;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PermissionMapper {

    @Select("select * from permission")
    List<Permission> queryFun();
}
