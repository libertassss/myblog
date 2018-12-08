package com.zyy.blog.modules.sys.service.impl;

import com.zyy.blog.modules.sys.dao.CategoryMapper;
import com.zyy.blog.modules.sys.entity.Category;
import com.zyy.blog.modules.sys.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public int insertCategory(Category category){
        return categoryMapper.insert(category);
    }

    @Override
    public Category selectByExample(Category category){
        category.setCategoryStatus(1);
        category.setCategoryOrder(1);
        return categoryMapper.selectByExample(category);
    }

    @Override
    public List<Category> selectAllCategory(){
        return categoryMapper.selectAllCategory();
    }
}
