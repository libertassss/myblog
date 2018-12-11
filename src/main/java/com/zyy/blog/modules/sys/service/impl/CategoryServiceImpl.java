package com.zyy.blog.modules.sys.service.impl;


import com.zyy.blog.commons.utils.BuildTree;
import com.zyy.blog.modules.sys.dao.CategoryMapper;
import com.zyy.blog.modules.sys.entity.Category;
import com.zyy.blog.modules.sys.service.CategoryService;
import com.zyy.blog.modules.sys.vo.ParamsVo;
import com.zyy.blog.modules.sys.vo.Tree;

import com.zyy.blog.modules.sys.vo.UserVo;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public int insertCategory(Category category){
        category.setCategoryStatus(1);
        category.setCategoryOrder(1);
        return categoryMapper.insert(category);
    }

    @Override
    public List<Category> selectByExample(Category category){

        return categoryMapper.selectByExample(category);
    }

    @Override
    public List<Tree<Category>> selectAllCategory(){
        List<Tree<Category>> trees=new ArrayList<Tree<Category>>();
        List<Category> results=  categoryMapper.selectAllCategory();
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
        return t;
    }

    @Override
    public int deleteCategory(Integer categoryId){
        return categoryMapper.deleteByPrimaryKey(categoryId);
    }

    @Override
    public int deleteCategoryMall(ParamsVo paramsVo){
        return categoryMapper.deleteCategoryMall(paramsVo.getItem());
    }
}
