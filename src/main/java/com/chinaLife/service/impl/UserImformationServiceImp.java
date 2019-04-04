package com.chinaLife.service.impl;

import com.chinaLife.dao.UserImformationMapper;
import com.chinaLife.model.UserImformation;
import com.chinaLife.service.UserImformationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserImformationServiceImp implements UserImformationService {

    @Resource
    private UserImformationMapper userImformationMapper;

    public List<UserImformation> QueryA() {
        List<UserImformation> list=userImformationMapper.queryAllUserTable();
        return list;
    }

    /*
    * 插入数据
    * */
    public int insertUserImformation(UserImformation userImformation) {
            try {
                int result=userImformationMapper.insert(userImformation);
                return result;
            }catch (Exception e ){
                System.out.println("数据写入失败");
                return 0;
            }
    }
    /*
    * 删除
    * */
    public int delectUserImformation(String username) {
        try{
            int result=userImformationMapper.deleteByPrimaryKey(username);
            return result;
        }catch (Exception e){
            System.out.println("删除失败");
            return 0;
        }
    }
    /*
    * 更新
    * */
    public int updateUserImformation(UserImformation userImformation) {
        try{
            int result=userImformationMapper.updateByPrimaryKey(userImformation);
            return result;
        }catch (Exception e){
            System.out.println("更新失败");
            return 0;
        }
    }

}
