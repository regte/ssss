package org.jk.dao;


import org.jk.entity.SysUserInfo;
import org.jk.entity.UserInfo;
import org.jk.util.PageUtil;

import java.util.List;

public interface UserInfoMapper {



















    int deleteByPrimaryKey(Integer userId);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);






}