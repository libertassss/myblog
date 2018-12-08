package com.zyy.blog.modules.sys.service.impl;

import com.zyy.blog.commons.utils.BuildTree;
import com.zyy.blog.modules.sys.dao.CategoryMapper;
import com.zyy.blog.modules.sys.entity.Category;
import com.zyy.blog.modules.sys.service.CategoryService;
import com.zyy.blog.modules.sys.vo.Tree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
    public List<Category> selectByExample(Category category){
        category.setCategoryStatus(1);
        category.setCategoryOrder(1);
        return categoryMapper.selectByExample(category);

    }

    @Override
    public Tree<Category> selectAllCategory(){
        List<Tree<Category>> trees=new ArrayList<Tree<Category>>();
        List<Category> results=  categoryMapper.selectAllCategory();
        for(Category result:results){
            Tree<Category> tree=new Tree<Category>();
            tree.setId(result.getCategoryId());
            tree.setParentid(result.getCategoryPid());
            trees.add(tree);
        }
        Tree<Category> t= BuildTree.build(trees);
        return t;
    }
}
