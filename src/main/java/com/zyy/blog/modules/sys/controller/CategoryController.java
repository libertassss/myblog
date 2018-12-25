package com.zyy.blog.modules.sys.controller;

import com.zyy.blog.commons.utils.BuildTree;
import com.zyy.blog.commons.utils.R;
import com.zyy.blog.modules.sys.entity.Category;
import com.zyy.blog.modules.sys.service.CategoryService;
import com.zyy.blog.modules.sys.vo.ParamsVo;
import com.zyy.blog.modules.sys.vo.Tree;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @RequestMapping("/insertCategory")
    @ResponseBody
    public R insertCategory(@RequestBody Category category){
        List<Category> results=categoryService.selectByExample(category);
        if(categoryService.selectByExample(category).size()==0){
            if(categoryService.insertCategory(category)==1){
                return R.ok("新增类别成功");
            }else{
                return R.error(500,"新增失败");
            }
        }else{
            return R.error(500,"类别已存在");
        }

    }

    @RequestMapping("/selectAllCategory")
    @ResponseBody
    public R selectAllCategory(){
        List<Category> results=categoryService.selectAllCategory();
        List<Tree<Category>> trees=new ArrayList<Tree<Category>>();
        for(Category result:results){
            Tree<Category> tree=new Tree<Category>();

            tree.setId(result.getCategoryId());
            tree.setParentid(result.getCategoryPid());
            try {
                BeanUtils.copyProperties(tree,result);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            trees.add(tree);
        }
        List<Tree<Category>> t= BuildTree.build(trees);
        if(results!=null)
            return R.ok().put("data",t);
        else
            return R.error(500,"暂无类别");
    }

//    删除单条数据
    @RequestMapping("/deleteCategory")
    @ResponseBody
    public R deleteCategory(@RequestBody Category category){
        int flag=categoryService.deleteCategory(category.getCategoryId());
        if(flag!=0)
            return R.ok("删除成功");
        else
            return R.error(500,"删除失败");
    }


//    批量删除
    @RequestMapping("/deleteCategoryMall")
    @ResponseBody
    public R deleteCategoryMall(@RequestBody ParamsVo paramsVo){
        int result = categoryService.deleteCategoryMall(paramsVo);
        if(result!=0){
            return R.ok("删除成功");
        }else{
            return R.error(500,"删除失败");
        }
    }

//类别list
    @RequestMapping("/selectAll")
    @ResponseBody
    public R selectAll(){
        if (categoryService.selectAll()!=null)
            return R.ok().put("data",categoryService.selectAll());
        else
            return R.error(500,"暂无类别");
    }
}
