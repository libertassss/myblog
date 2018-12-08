package com.zyy.blog.modules.sys.service;

import com.zyy.blog.modules.sys.entity.Category;
import com.zyy.blog.modules.sys.vo.Tree;

import javax.validation.constraints.Null;
import java.util.List;

public interface CategoryService {
    int insertCategory(Category category);


    List<Category> selectByExample(Category category);

    Tree<Category> selectAllCategory();
}
