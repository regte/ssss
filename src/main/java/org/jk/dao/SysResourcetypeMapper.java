package org.jk.dao;


import org.jk.entity.SysResourcetype;

public interface SysResourcetypeMapper {
    int deleteByPrimaryKey(String id);

    int insert(SysResourcetype record);

    int insertSelective(SysResourcetype record);

    SysResourcetype selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysResourcetype record);

    int updateByPrimaryKey(SysResourcetype record);
}