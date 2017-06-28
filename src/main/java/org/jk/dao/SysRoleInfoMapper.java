package org.jk.dao;


import org.jk.entity.SysRoleInfo;

public interface SysRoleInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(SysRoleInfo record);

    int insertSelective(SysRoleInfo record);

    SysRoleInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysRoleInfo record);

    int updateByPrimaryKey(SysRoleInfo record);
}