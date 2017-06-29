package org.jk.controller;

import org.jk.entity.SysRoleInfo;
import org.jk.service.RoleService;
import org.jk.util.DataGridJson;
import org.jk.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    /*查询角色列表*/
    @RequestMapping(value = "selectRoleList",method = RequestMethod.POST)
    @ResponseBody
    public DataGridJson selectRoleList(Integer page , Integer rows, PageUtil<SysRoleInfo> pageUtil){
        DataGridJson dj = new DataGridJson();

        pageUtil.setCpage(page);
        pageUtil.setPageSize(rows);
        roleService.selectRoleList(pageUtil);

        dj.setRows(pageUtil.getList());
        dj.setTotal(pageUtil.getTotalCount());
        return dj;
    }

    /*跳转角色页面*/
    @RequestMapping(value = "toRoleList",method = RequestMethod.GET)
    public String toRoleList(){
        return "role/role-list";
    }
}
