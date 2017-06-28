package org.jk.dao;


import org.jk.entity.SysUserSysroleKey;

public interface SysUserSysroleMapper {
    int deleteByPrimaryKey(SysUserSysroleKey key);

    int insert(SysUserSysroleKey record);

    int insertSelective(SysUserSysroleKey record);
}