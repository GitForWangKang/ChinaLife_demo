package com.chinaLife.dao;

import com.chinaLife.model.UserImformation;

import java.util.List;

public interface UserImformationMapper {
    int deleteByPrimaryKey(String username);

    int insert(UserImformation record);

    int insertSelective(UserImformation record);

    UserImformation selectByPrimaryKey(String username);

    int updateByPrimaryKeySelective(UserImformation record);

    int updateByPrimaryKey(UserImformation record);

    List<UserImformation> queryAllUserTable();


}