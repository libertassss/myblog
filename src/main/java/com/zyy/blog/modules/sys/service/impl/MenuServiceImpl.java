package com.zyy.blog.modules.sys.service.impl;

import com.zyy.blog.modules.sys.dao.MenuMapper;
import com.zyy.blog.modules.sys.entity.Menu;
import com.zyy.blog.modules.sys.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MenuServiceImpl implements MenuService {
    @Autowired
    MenuMapper menuMapper;

    @Override
    public int insert(Menu menu){
      return menuMapper.insert(menu);
    }
}
