package com.zyy.blog.modules.sys.controller;

import com.zyy.blog.commons.controller.Md5;
import com.zyy.blog.modules.sys.dao.UserMapper;
import com.zyy.blog.modules.sys.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import java.util.Date;


@Controller
public class UserController {
    @Autowired
    UserMapper userMapper;
    @RequestMapping("/register")
    @ResponseBody
    public String register(@RequestBody User user) throws UnsupportedEncodingException, NoSuchAlgorithmException {
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        user.setUserRegisterTime(new Date());
        Md5 md5=new Md5();
        String userPass=md5.EncoderByMd5(user.getUserPass());
        user.setUserPass(userPass);
        userMapper.insert(user);
        return "成功";
    }

    @RequestMapping("/index")
    public String login() {
        return "modules/sys/index";
    }

}
