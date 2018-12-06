package com.zyy.blog.modules.sys.controller;

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
}