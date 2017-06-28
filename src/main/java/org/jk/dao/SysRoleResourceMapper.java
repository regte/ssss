package org.jk.dao;


import org.jk.entity.SysRoleResourceKey;

public interface SysRoleResourceMapper {
    int deleteByPrimaryKey(SysRoleResourceKey key);

    int insert(SysRoleResourceKey record);

    int insertSelective(SysRoleResourceKey record);
}