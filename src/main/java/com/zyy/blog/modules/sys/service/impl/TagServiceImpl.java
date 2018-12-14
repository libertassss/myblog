package com.zyy.blog.modules.sys.service.impl;

import com.zyy.blog.modules.sys.dao.TagMapper;
import com.zyy.blog.modules.sys.entity.Tag;
import com.zyy.blog.modules.sys.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TagServiceImpl implements TagService {
    @Autowired
    TagMapper tagMapper;

    @Override
    public List<Tag> selectAllTags(){
        return tagMapper.selectAllTags();
    }

    @Override
    public int insertTag(Tag tag){
        return tagMapper.insert(tag);
    }
}
