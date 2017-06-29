package org.jk.controller;

import org.jk.business.Tree;
import org.jk.entity.Sysresource;
import org.jk.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by dell on 2017/6/28.
 */
@Controller
@RequestMapping("tree")
public class TreeController {

    @Autowired
    private ResourceService resourceService;


    /*查询左侧树*/
    @RequestMapping(value="selectMainMenu",method=RequestMethod.POST)
    @ResponseBody
    public ArrayList<Tree> selectMainMenu(){
        
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
                    yiji.setState("closed");
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
                            child.setState("closed");
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




    /*跳转主页面*/
    @RequestMapping(value = "toMain",method = RequestMethod.GET)
    public String toMain(){
        return  "main/main";
    }
}
