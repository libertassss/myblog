package com.zyy.blog.modules.sys.controller;

import com.zyy.blog.commons.utils.R;
import com.zyy.blog.commons.utils.Upload;
import com.zyy.blog.modules.sys.entity.Article;
import com.zyy.blog.modules.sys.entity.ArticleWithBLOBs;
import com.zyy.blog.modules.sys.service.ArticleService;
import com.zyy.blog.modules.sys.vo.ArticleListVo;
import com.zyy.blog.modules.sys.vo.ParamsVo;
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

    /**
     * 上传图片
     * @param req
     * @param file
     * @return
     */
    @RequestMapping("/uploadImg")
    @ResponseBody
    public R uploadImg(HttpServletRequest req, @RequestParam("file") MultipartFile file){
        Upload upload=new Upload();
        return upload.Uopload(req,file);
    }

    /**
     * 新增文章
     * @param articleWithBLOBs
     * @return
     */
    @RequestMapping("/insertSelectev")
    @ResponseBody
    public R insertSelectev(@RequestBody ArticleWithBLOBs articleWithBLOBs){
        int flag=articleService.insertSelective(articleWithBLOBs);
        if (flag!=0)
            return R.ok("成功");
        else return R.error(500,"失败");
    }

    /**
     * 文章列表
     * @return
     */
    @RequestMapping("/selectAllArticle")
    @ResponseBody
    public R selectAllArticle(){
        List<ArticleListVo> result=articleService.selectAllArticle();
        if(result!=null){

            return R.ok().put("data",articleService.selectAllArticle());
        }

        else return R.error(500,"暂无文章列表");
    }

    /**
     * 删除文章，单条
     * @param article
     * @return
     */
    @RequestMapping("/deleteByPrimaryKey")
    @ResponseBody
    public R deleteByPrimaryKey(@RequestBody Article article){
        int flag=articleService.deleteByPrimaryKey(article.getArticleId());
        if(flag!=0)
            return R.ok("删除成功");
        else return R.error(500,"删除失败");
    }

    /**
     * 编辑
     * @param article
     * @return
     */
    @RequestMapping("/updateByPrimaryKey")
    @ResponseBody
    public R updateByPrimaryKey(@RequestBody Article article){
        int flag=articleService.updateByPrimaryKey(article);
        if(flag!=0)
            return R.ok("修改成功");
        else return R.error(500,"修改失败");
    }

    /**
     * 批量删除
     * @param paramsVo
     * @return
     */
    @RequestMapping("/deleteArticleMall")
    @ResponseBody
    public R deleteArticleMall(@RequestBody ParamsVo paramsVo){
        int flag=articleService.deleteArticleMall(paramsVo);
        if(flag!=0)
            return R.ok("删除成功");
        else return R.error(500,"删除失败");
    }

}
