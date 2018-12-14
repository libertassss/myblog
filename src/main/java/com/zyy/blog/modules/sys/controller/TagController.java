package com.zyy.blog.modules.sys.controller;

import com.zyy.blog.commons.utils.R;
import com.zyy.blog.modules.sys.entity.Tag;
import com.zyy.blog.modules.sys.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TagController {
    @Autowired
    TagService tagService;

    @RequestMapping("/selectAllTags")
    @ResponseBody
    public R selectAllTags(){
        if (tagService.selectAllTags()!=null)
            return R.ok().put("data",tagService.selectAllTags());
        else return R.error(500,"暂无标签");
    }

    @RequestMapping("/insertTag")
    @ResponseBody
    public R insertTag(@RequestBody Tag tag){
        if (tagService.insertTag(tag)!=0)
            return R.ok("新增成功");
        else return R.error(500,"新增失败");
    }
}
