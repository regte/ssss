package org.jk.service;

import org.jk.dao.SysUserInfoMapper;
import org.jk.entity.SysUserInfo;
import org.jk.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dell on 2017/6/28.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private SysUserInfoMapper userInfoMapper;

    @Override
    public PageUtil<SysUserInfo> selectUserList(PageUtil<SysUserInfo> userPage) {

        List<SysUserInfo> userInfoList = userInfoMapper.selectUserList(userPage);

        int a = userInfoMapper.selectUserCount(userPage);

        userPage.setList(userInfoList);

        userPage.setTotalCount(a);

        return userPage;
    }
}
