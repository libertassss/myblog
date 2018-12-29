package com.zyy.blog.modules.sys.service;

import com.zyy.blog.modules.sys.entity.Menu;

import java.util.List;

public interface MenuService {
    int insert(Menu menu);

    /**
     * 新增
     * @param menu
     * @return
     */
    int insertSelective(Menu menu);

    /**
     * 查询所有
     * @return
     */
    List<Menu> selectAll();

    /**
     * 单条删除
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 编辑
     * @param menu
     * @return
     */
    int updateByPrimaryKeySelective(Menu menu);
}
