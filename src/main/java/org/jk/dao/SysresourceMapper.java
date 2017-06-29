package org.jk.dao;
import org.jk.entity.Sysresource;

import java.util.List;

import java.util.List;
public interface SysresourceMapper {
    //删除
    void deleteByPrimaryKey(String id);
    int insert(Sysresource record);
    int updateByPrimaryKey(Sysresource record);
//修改
    void updateResource(Sysresource resource);
    //修改回写
    Sysresource showResource(String id);
//添加
    void addResrouce(Sysresource resource);
//通过id查询
    List<Sysresource> selectResourceList(String id);
    //		根据用户id查询拥有的resource资源权限
    List<Sysresource> selectResourceByUserId(String userId);
    //查询所有资源树
    List<Sysresource> getResourceTree();


}