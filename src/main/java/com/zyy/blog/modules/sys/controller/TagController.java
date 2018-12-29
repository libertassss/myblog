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

    /**
     * 查询所有
     * @return
     */
    @RequestMapping("/selectAllTags")
    @ResponseBody
    public R selectAllTags(){
        if (tagService.selectAllTags()!=null)
            return R.ok().put("data",tagService.selectAllTags());
        else return R.error(500,"暂无标签");
    }

    /**
     * 新增标签
     * @param tag
     * @return
     */
    @RequestMapping("/insertTag")
    @ResponseBody
    public R insertTag(@RequestBody Tag tag){
        tag.setTagStatus(1);
        int flag=tagService.insertTag(tag);
        if (flag!=0)
            return R.ok("新增成功");
        else return R.error(500,"新增失败");
    }

    /**
     * 单条删除
     * @param tag
     * @return
     */
    @RequestMapping("/deleteTag")
    @ResponseBody
    public R deleteTag(@RequestBody Tag tag){
        int flag=tagService.deleteTag(tag);
        if(flag!=0)
            return R.ok("删除成功");
        else return R.error(500,"删除失败");
    }
}
