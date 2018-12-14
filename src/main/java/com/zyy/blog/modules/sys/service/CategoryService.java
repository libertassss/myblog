package com.zyy.blog.modules.sys.service;

import com.zyy.blog.modules.sys.entity.Category;
import com.zyy.blog.modules.sys.vo.ParamsVo;
import com.zyy.blog.modules.sys.vo.Tree;

import java.util.List;

public interface CategoryService {
    int insertCategory(Category category);


    List<Category> selectByExample(Category category);

    List<Tree<Category>> selectAllCategory();

    int deleteCategory(Integer categoryId);

    int deleteCategoryMall(ParamsVo paramsVo);

    List<Category> selectAll();
}
