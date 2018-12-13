package com.zyy.blog.commons.utils;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

public class Upload {
    private String URL="http://127.0.0.1/";
    public R Uopload(HttpServletRequest req, @RequestParam("file") MultipartFile file){
        if(!file.isEmpty()) {
            String fileName = System.currentTimeMillis() + file.getOriginalFilename();
            String destFileName = req.getSession().getServletContext().getRealPath("/");
            File fil=new File(destFileName+fileName);
            try {
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(fil));
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
            return R.ok().put("url",fileName);       //返回上传文件的访问路径   getAbsolutePath()返回文件上传的绝对路径
        }else {
            return R.error(500, "文件上传失败,文件为空");
        }

    }
}
