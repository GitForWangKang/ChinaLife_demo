package com.chinaLife.service;

import com.chinaLife.model.UserImformation;

import java.util.List;

public interface UserImformationService {
    //查询所有
    List<UserImformation> QueryA();
    //插入
    int insertUserImformation(UserImformation userImformation);
    //删除
    int delectUserImformation(String username);
    //更新
    int updateUserImformation(UserImformation username);
}
