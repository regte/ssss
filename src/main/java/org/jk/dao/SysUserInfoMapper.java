package org.jk.dao;


import org.jk.entity.SysUserInfo;

public interface SysUserInfoMapper {
    int deleteByPrimaryKey(String sysuserId);

    int insert(SysUserInfo record);

    int insertSelective(SysUserInfo record);

    SysUserInfo selectByPrimaryKey(String sysuserId);

    int updateByPrimaryKeySelective(SysUserInfo record);

    int updateByPrimaryKey(SysUserInfo record);
}