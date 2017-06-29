package org.jk.dao;


import org.jk.entity.Sysresource;

import java.util.List;

public interface SysresourceMapper {
    int deleteByPrimaryKey(String id);

    int insert(Sysresource record);

    int insertSelective(Sysresource record);

    Sysresource selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Sysresource record);

    int updateByPrimaryKey(Sysresource record);

    List<Sysresource> getResourceTree();
}