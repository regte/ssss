package org.jk.service;

import org.jk.entity.SysRoleInfo;
import org.jk.util.PageUtil;

/**
 * Created by dell on 2017/6/29.
 */
public interface RoleService {


    void selectRoleList(PageUtil<SysRoleInfo> pageUtil);
}
