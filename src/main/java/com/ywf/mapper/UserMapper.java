package com.ywf.mapper;

import com.ywf.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    User getUser(@Param("name") String name,@Param("pwd") String pwd);
}
