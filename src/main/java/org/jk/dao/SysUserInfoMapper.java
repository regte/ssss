package org.jk.dao;


import org.jk.entity.SysUserInfo;
import org.jk.util.PageUtil;

import java.util.List;

public interface SysUserInfoMapper {
    int deleteByPrimaryKey(String sysuserId);

    int insert(SysUserInfo record);

    int insertSelective(SysUserInfo record);

    SysUserInfo selectByPrimaryKey(String sysuserId);

    int updateByPrimaryKeySelective(SysUserInfo record);

    int updateByPrimaryKey(SysUserInfo record);

    List<SysUserInfo> selectUserList(PageUtil<SysUserInfo> userPage);

    int selectUserCount(PageUtil<SysUserInfo> userPage);
}