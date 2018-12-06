package com.zyy.blog.modules.sys.controller;

import com.zyy.blog.modules.sys.dao.CategoryMapper;
import com.zyy.blog.modules.sys.entity.Category;
import com.zyy.blog.modules.sys.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @RequestMapping("/insertCategory")
    @ResponseBody
    public int insertCategory(@RequestBody Category category){
        return categoryService.insertCategory(category);
    }
}
