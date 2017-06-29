package org.jk.service;

import org.jk.dao.SysRoleInfoMapper;
import org.jk.entity.SysRoleInfo;
import org.jk.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dell on 2017/6/29.
 */
@Service
public class RoleServiceImpl  implements  RoleService {
    @Autowired
    private SysRoleInfoMapper roleMapper;


    @Override
    public void selectRoleList(PageUtil<SysRoleInfo> pageUtil) {

        List<SysRoleInfo>  roleInfoList = roleMapper.selectRoleList(pageUtil);

        int a = roleMapper.selectCount(pageUtil);

        pageUtil.setTotalCount(a);
        pageUtil.setList(roleInfoList);

    }
}
