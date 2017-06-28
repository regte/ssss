package org.jk.business;

import org.jk.entity.SysUserInfo;

/**
 * sessionInfo只要登录成功，就需要设置到session里面，便于系统使用
 * 
 */
public class SessionInfo implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7145049418287239762L;
	
	private SysUserInfo sysUserInfo;

	public SysUserInfo getUser() {
		return sysUserInfo;
	}

	public SysUserInfo getSysUserInfo() {
		return sysUserInfo;
	}

	public void setSysUserInfo(SysUserInfo sysUserInfo) {
		this.sysUserInfo = sysUserInfo;
	}
}
