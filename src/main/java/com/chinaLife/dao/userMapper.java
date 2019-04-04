package com.chinaLife.dao;

import com.chinaLife.model.user;
import java.util.List;

public interface userMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(user record);

    user selectByPrimaryKey(Integer id);

    List<user> selectAll();

    int updateByPrimaryKey(user record);
}