package org.jk.service;

import org.jk.entity.SysResourcetype;
import org.jk.entity.Sysresource;

import java.util.List;

/**
 * Created by dell on 2017/6/28.
 */
public interface ResourceService {

    Sysresource showResource(String id);

    void updateResource(Sysresource resource);

    List<SysResourcetype> selectResourceTypeList();

    void deleteResource(String id);

    void addResrouce(Sysresource resource);

    List<Sysresource> selectResourceList(String id);



    List<Sysresource> selectResourceByUserId(String userId);

    List<Sysresource> getResourceTree();

}
