package org.jk.controller;

import org.jk.entity.SysUserInfo;
import org.jk.entity.UserInfo;
import org.jk.service.UserService;
import org.jk.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dell on 2017/6/28.
 */
@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;


    @RequestMapping(value = "selectUserList",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> selectUserList(Integer page, Integer rows, PageUtil<SysUserInfo> userPage){

/*		PageUtil<User> userPage = new PageUtil<>();*/
        userPage.setCpage(page);
        userPage.setPageSize(rows);
        //查询条件---map
        System.out.println(userPage.getWhereMap());
        //分页查询
        userPage = userService.selectUserList(userPage);

        //封装到map 设置easyui的datagrid组件识别的json字符串
        Map<String,Object> map = new HashMap<>();
        map.put("total", userPage.getTotalCount());
        map.put("rows", userPage.getList());

        return map;
    }

    @RequestMapping("toUserList")
    public String toUserList(){
        return "user/userList";
    }




}

