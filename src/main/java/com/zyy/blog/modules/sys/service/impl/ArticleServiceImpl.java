package com.zyy.blog.modules.sys.service.impl;

import com.zyy.blog.modules.sys.dao.ArticleMapper;
import com.zyy.blog.modules.sys.entity.ArticleWithBLOBs;
import com.zyy.blog.modules.sys.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleMapper articleMapper;

    @Override
    public int insertSelective(ArticleWithBLOBs articleWithBLOBs){
        articleWithBLOBs.setArticlePostTime(new Date());
        articleWithBLOBs.setArticleIsComment(1);
        articleWithBLOBs.setArticleOrder(1);
        return articleMapper.insertSelective(articleWithBLOBs);
    }
}
