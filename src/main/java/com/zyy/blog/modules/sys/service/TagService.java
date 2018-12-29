package com.zyy.blog.modules.sys.service;

import com.zyy.blog.modules.sys.entity.Tag;

import java.util.List;

public interface TagService {
    List<Tag> selectAllTags();

    int insertTag(Tag tag);

    int deleteTag(Tag tag);
}
