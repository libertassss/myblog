package com.zyy.blog.modules.sys.service.impl;

import com.zyy.blog.modules.sys.dao.ArticleMapper;
import com.zyy.blog.modules.sys.entity.ArticleWithBLOBs;
import com.zyy.blog.modules.sys.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleMapper articleMapper;

    @Override
    public int insertSelective(ArticleWithBLOBs articleWithBLOBs){
        return articleMapper.insertSelective(articleWithBLOBs);
    }
}
