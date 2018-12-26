package com.zyy.blog.modules.sys.controller;

import com.zyy.blog.commons.utils.R;
import com.zyy.blog.commons.utils.Upload;
import com.zyy.blog.modules.sys.entity.Article;
import com.zyy.blog.modules.sys.entity.ArticleWithBLOBs;
import com.zyy.blog.modules.sys.service.ArticleService;
import com.zyy.blog.modules.sys.vo.ArticleListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ArticleController {
    @Autowired
    ArticleService articleService;
//上传图片
    @RequestMapping("/uploadImg")
    @ResponseBody
    public R uploadImg(HttpServletRequest req, @RequestParam("file") MultipartFile file){
        Upload upload=new Upload();
        return upload.Uopload(req,file);
    }
//文章提交
    @RequestMapping("/insertSelectev")
    @ResponseBody
    public R insertSelectev(@RequestBody ArticleWithBLOBs articleWithBLOBs){
        int flag=articleService.insertSelective(articleWithBLOBs);
        if (flag!=0)
            return R.ok("成功");
        else return R.error(500,"失败");
    }

    @RequestMapping("/selectAllArticle")
    @ResponseBody
    public R selectAllArticle(){
        List<ArticleListVo> result=articleService.selectAllArticle();
        if(result!=null){

            return R.ok().put("data",articleService.selectAllArticle());
        }

        else return R.error(500,"暂无文章列表");
    }

    @RequestMapping("/deleteByPrimaryKey")
    @ResponseBody
    public R deleteByPrimaryKey(@RequestBody Article article){
        int flag=articleService.deleteByPrimaryKey(article.getArticleId());
        if(flag!=0)
            return R.ok("删除成功");
        else return R.error(500,"删除失败");
    }

    @RequestMapping("/updateByPrimaryKey")
    @ResponseBody
    public R updateByPrimaryKey(@RequestBody Article article){
        int flag=articleService.updateByPrimaryKey(article);
        if(flag!=0)
            return R.ok("修改成功");
        else return R.error(500,"修改失败");
    }

}
