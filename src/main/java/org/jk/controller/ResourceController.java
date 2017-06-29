package org.jk.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


import org.jk.business.SessionInfo;
import org.jk.business.Tree;
import org.jk.entity.SysResourcetype;
import org.jk.entity.SysRoleInfo;
import org.jk.entity.SysRoleResourceKey;
import org.jk.entity.Sysresource;
import org.jk.service.ResourceService;
import org.jk.util.ConfigUtil;
import org.jk.util.ReturnJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
/**
 * Created by dell on 2017/6/28.
 */
@Controller
@RequestMapping("resource")
public class ResourceController {
    @Autowired
    private ResourceService resourceService;
    /**
     * 跳转到 addResource.jsp
     * @return
     */
    @RequestMapping(value="showResource")
    public ModelAndView showResource(HttpServletRequest req,String id){
        Sysresource s=resourceService.showResource(id);
        ModelAndView m=	 new ModelAndView("resource/addResource");
        m.addObject("ss",s);
        return m;
    }
    /**
     * 修改
     * @return
     */
    @RequestMapping(value="updateResource")
    @ResponseBody
    public ReturnJson updateResource(HttpServletRequest req,Sysresource resource){
        resourceService.updateResource(resource);
        return new ReturnJson(true,"修改成功",null);
    }
    /**
     *查询资源类型
     */
    @RequestMapping(value="selectResourceTypeList")
    @ResponseBody
    public List<SysResourcetype> selectResourceTypeList(){
        return resourceService.selectResourceTypeList();
    }

    /**
     *  deleteResource 删除权限
     * @return
     */
    @RequestMapping(value="deleteResource",method=RequestMethod.POST)
    @ResponseBody
    public  ReturnJson deleteResource(String id){
        resourceService.deleteResource(id);
        return new ReturnJson(true,"删除成功",null);
    }
    /**
     *  addResource 新增
     * @return
     */
    @RequestMapping(value="addResource",method=RequestMethod.POST)
    @ResponseBody
    public  ReturnJson addResource(Sysresource resource){
        resourceService.addResrouce(resource);
        return new ReturnJson(true,"添加成功",null);
    }

    /**
     * 跳转到 addResource.jsp
     * @return
     */
    @RequestMapping(value="toAddResource")
    public ModelAndView toAddResource(){
        return new ModelAndView("resource/addResource");
    }
    //查询list集合
    @RequestMapping(value="selectResourceList",method=RequestMethod.POST)
    @ResponseBody
    public List<Sysresource> selectResourceList(String id){
        //查询list集合
        List<Sysresource> resourceList = 	resourceService.selectResourceList(id);
        return resourceList;
    }
    /**
     * 查询所有的权限资源tree
     * @return
     */
    @RequestMapping(value="getResourceTree",method=RequestMethod.POST)
    @ResponseBody
    public  ArrayList<Tree>  getResourceTree(){
        List<Sysresource> resourceList =  resourceService.getResourceTree();
        ArrayList<Tree> treeList = new ArrayList<>();
        //一级节点
        Tree yiji = null;
        //子节点list
        ArrayList<Tree> childList = null;
        //子级节点
        Tree child = null;
        //节点的自定义属性 如 url等。。。
        HashMap<String, String> nodeAttr = null;
        for (int i = 0; i < resourceList.size(); i++) {
            //pid== null 说明一级节点
            if (resourceList.get(i).getPid() == null) {
                yiji = new Tree();
                yiji.setId(resourceList.get(i).getId());
                yiji.setText(resourceList.get(i).getName());
                yiji.setIconCls(resourceList.get(i).getIconcls());
                yiji.setState("open");
                childList = new ArrayList<>();

                //循环遍历子节点
                for (int j = 0; j < resourceList.size(); j++) {
                    //当前循环的节点的父级id 等于  上层循环节点的id
                    if (resourceList.get(j).getPid() != null &&
                            resourceList.get(i).getId().equals(resourceList.get(j).getPid()) ) {
                        //实例化子节点
                        child = new Tree();
                        //节点属性赋值
                        child.setId(resourceList.get(j).getId());
                        child.setText(resourceList.get(j).getName());
                        child.setIconCls(resourceList.get(j).getIconcls());
                        child.setPid(resourceList.get(j).getPid());
                        child.setState("open");
                        //实例化 自定义节点属性map
                        nodeAttr = new HashMap<>();
                        nodeAttr.put("url", resourceList.get(j).getUrl());
                        child.setAttributes(nodeAttr);
                        //子节点list 添加 child节点
                        childList.add(child);

                        //循环递归调用
                        selectChildList(resourceList, child);
                    }
                }
                yiji.setChildren(childList);
                treeList.add(yiji);
            }
        }
        return treeList;
    }


    //封装递归方法
    private void selectChildList(List<Sysresource> resourceList,Tree prarentNode){
        //子节点list
        ArrayList<Tree> childList = new ArrayList<>();
        //子级节点
        Tree child = null;
        //节点的自定义属性 如 url等。。。
        HashMap<String, String> nodeAttr = null;
        //循环遍历子节点
        for (int j = 0; j < resourceList.size(); j++) {
            //当前循环的节点的父级id 等于  上层循环节点的id
            if (resourceList.get(j).getPid() != null &&
                    prarentNode.getId().equals(resourceList.get(j).getPid()) ) {
                //实例化子节点
                child = new Tree();
                //节点属性赋值
                child.setId(resourceList.get(j).getId());
                child.setText(resourceList.get(j).getName());
                child.setIconCls(resourceList.get(j).getIconcls());
                child.setPid(resourceList.get(j).getPid());
                child.setState("open");
                //实例化 自定义节点属性map
                nodeAttr = new HashMap<>();
                nodeAttr.put("url", resourceList.get(j).getUrl());
                child.setAttributes(nodeAttr);
                //子节点list 添加 child节点
                childList.add(child);

                //递归调用查找子节点 n层
                selectChildList(resourceList, child);
            }
        }
        prarentNode.setChildren(childList);

    }

    /**
     * 跳转到 resourceList.jsp
     * @return
     */
    @RequestMapping("toResourceList")
    public ModelAndView toResourceList(){
        return new ModelAndView("resource/resourceList");
    }

    /**
     *  授予权限/修改权限
     *  1.根据角色id删除 角色权限信息
     *  2.添加 重新授予的 角色权限信息
     * @param roleResource
     * @return

    @RequestMapping(value="grantResourceOfRole",method=RequestMethod.POST)
    @ResponseBody
    public ReturnJson grantResourceOfRole(SysRoleResourceKey roleResource){

        roleResourceService.updateResourceOfRole(roleResource);

        return new ReturnJson(true, "授予权限成功", null);
    }
     */
    /**
     * 根据角色id查询拥有的权限资源list
     * @param role
     * @return

    @RequestMapping(value="getResourceByRoleId",method=RequestMethod.POST)
    @ResponseBody
    public List<SysRoleResourceKey> getResourceByRoleId(SysRoleInfo role){

        List<SysRoleResourceKey> roleResourceList = roleResourceService.getResourceByRoleId(role);

        return roleResourceList;
    }
     */









}
