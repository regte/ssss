package org.jk.dao;


import org.jk.entity.Sysresource;

public interface SysresourceMapper {
    int deleteByPrimaryKey(String id);

    int insert(Sysresource record);

    int insertSelective(Sysresource record);

    Sysresource selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Sysresource record);

    int updateByPrimaryKey(Sysresource record);
}