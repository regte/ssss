package org.jk.service;

import org.jk.dao.SysresourceMapper;
import org.jk.entity.Sysresource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dell on 2017/6/28.
 */
@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
   private SysresourceMapper sysresourceMapper;

    @Override
    public List<Sysresource> getResourceTree() {
        return sysresourceMapper.getResourceTree();
    }
}
