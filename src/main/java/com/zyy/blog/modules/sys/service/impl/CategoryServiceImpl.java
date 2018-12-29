package com.zyy.blog.modules.sys.service.impl;


import com.zyy.blog.commons.utils.BuildTree;
import com.zyy.blog.modules.sys.dao.CategoryMapper;
import com.zyy.blog.modules.sys.entity.Category;
import com.zyy.blog.modules.sys.service.CategoryService;
import com.zyy.blog.modules.sys.vo.ParamsVo;
import com.zyy.blog.modules.sys.vo.Tree;


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
    public List<Category> selectAllCategory(){

        List<Category> results=  categoryMapper.selectAllCategory();
        return results;

    }

    @Override
    public int deleteCategory(Integer categoryId){
        return categoryMapper.deleteByPrimaryKey(categoryId);
    }

    /**
     * 批量删除
     * @param paramsVo
     * @return
     */
    @Override
    public int deleteCategoryMall(ParamsVo paramsVo){
        return categoryMapper.deleteCategoryMall(paramsVo.getItem());
    }

    @Override
    public List<Category> selectAll(){
        return categoryMapper.selectAllCategory();
    }
}
