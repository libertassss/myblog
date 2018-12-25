package com.zyy.blog.commons.utils;

import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

public class Upload {
    private String URL="localhost:8081/static/images/uplaod/";
    public R Uopload(HttpServletRequest req, @RequestParam("file") MultipartFile file){
        if(!file.isEmpty()) {
            String fileName = System.currentTimeMillis() + file.getOriginalFilename();
            File path= null;
            try {
//                获取项目根路径
                path = new File(ResourceUtils.getURL("classpath:").getPath());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            if(!path.exists()){
                path=new File("");
            }
            File upload=new File(path.getAbsolutePath(),"static/images/uplaod/");
            if(!upload.exists()){
                upload.mkdirs();
            }
            File files=new File(upload+"/"+fileName);
            try {
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(files));
                out.write(file.getBytes());
                out.flush();
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return R.error(500, "文件上传失败{}" + e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
                return R.error(500, "文件上传失败{}" + e.getMessage());
            }
            return R.ok().put("url",URL+fileName);       //返回上传文件的访问路径   getAbsolutePath()返回文件上传的绝对路径
        }else {
            return R.error(500, "文件上传失败,文件为空");
        }

    }
}
