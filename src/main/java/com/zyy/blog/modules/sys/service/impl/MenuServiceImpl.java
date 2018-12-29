package com.zyy.blog.modules.sys.service.impl;

import com.zyy.blog.modules.sys.dao.MenuMapper;
import com.zyy.blog.modules.sys.entity.Menu;
import com.zyy.blog.modules.sys.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MenuServiceImpl implements MenuService {
    @Autowired
    MenuMapper menuMapper;

    @Override
    public int insert(Menu menu){
      return menuMapper.insert(menu);
    }

    @Override
    public int insertSelective(Menu menu){
        menu.setMenuOrder(0);
        menu.setMenuStatus(1);
        return menuMapper.insertSelective(menu);
    }

    /**
     * 查询所有
     * @return
     */
    @Override
    public List<Menu> selectAll(){return menuMapper.selectAll();}

    /**
     * 单条删除
     * @param id
     * @return
     */
    @Override
    public int deleteByPrimaryKey(Integer id){
        return menuMapper.deleteByPrimaryKey(id);
    }

    /**
     * 编辑
     * @param menu
     * @return
     */
    @Override
    public int updateByPrimaryKeySelective(Menu menu){return menuMapper.updateByPrimaryKeySelective(menu);}
}
