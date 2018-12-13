package com.zyy.blog.modules.sys.controller;

import com.zyy.blog.commons.utils.R;
import com.zyy.blog.commons.utils.Upload;
import com.zyy.blog.modules.sys.entity.ArticleWithBLOBs;
import com.zyy.blog.modules.sys.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ArticleController {
    @Autowired
    ArticleService articleService;

    @RequestMapping("/uploadImg")
    @ResponseBody
    public R uploadImg(HttpServletRequest req, @RequestParam("file") MultipartFile file){
        Upload upload=new Upload();
        return upload.Uopload(req,file);
    }

    @RequestMapping("/insertSelectev")
    @ResponseBody
    public R insertSelectev(@RequestBody ArticleWithBLOBs articleWithBLOBs){
        if (articleService.insertSelective(articleWithBLOBs)!=0)
            return R.ok("成功");
        else return R.error(500,"失败");
    }

}
