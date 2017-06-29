package org.jk.service;

import org.jk.entity.Sysresource;

import java.util.List;

/**
 * Created by dell on 2017/6/28.
 */
public interface ResourceService {
    List<Sysresource> getResourceTree();
}
