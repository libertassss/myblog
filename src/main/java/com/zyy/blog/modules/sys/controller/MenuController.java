package com.zyy.blog.modules.sys.controller;

import com.zyy.blog.commons.utils.R;
import com.zyy.blog.modules.sys.entity.Menu;
import com.zyy.blog.modules.sys.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MenuController {
    @Autowired
    MenuService menuService;

    @RequestMapping("/insertMenu")
    @ResponseBody
    public int insertMenu(@RequestBody Menu menu){
       return menuService.insert(menu);
    }

    /**
     * 新增menu
     * @param menu
     * @return
     */
    @RequestMapping("/insertMenuItem")
    @ResponseBody
    public R insertSelective(@RequestBody Menu menu){
        int flag=menuService.insertSelective(menu);
        if(flag!=0)
            return R.ok("新增成功");
        else
            return R.error(500,"新增失败");
    }

    /**
     * 删除
     * @param menu
     * @return
     */
    @RequestMapping("/deleteMenu")
    @ResponseBody
    public R deleteByPrimaryKey(Menu menu){
        int flag=menuService.deleteByPrimaryKey(menu.getMenuId());
        if(flag!=0)
            return R.ok("删除成功");
        else
            return R.error(500,"删除失败");
    }
}