package org.jk.dao;


import org.jk.entity.SysRoleInfo;
import org.jk.util.PageUtil;

import java.util.List;

public interface SysRoleInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(SysRoleInfo record);

    int insertSelective(SysRoleInfo record);

    SysRoleInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysRoleInfo record);

    int updateByPrimaryKey(SysRoleInfo record);



    int selectCount(PageUtil<SysRoleInfo> pageUtil);

    List<SysRoleInfo> selectRoleList(PageUtil<SysRoleInfo> pageUtil);
}