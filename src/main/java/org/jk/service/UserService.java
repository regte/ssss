package org.jk.service;

import org.jk.entity.SysUserInfo;
import org.jk.entity.UserInfo;
import org.jk.util.PageUtil;

/**
 * Created by dell on 2017/6/28.
 */
public interface UserService {
    PageUtil<SysUserInfo> selectUserList(PageUtil<SysUserInfo> userPage);

}
