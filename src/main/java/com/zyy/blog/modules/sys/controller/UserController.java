package com.zyy.blog.modules.sys.controller;

import com.zyy.blog.commons.config.WebSecurityConfig;
import com.zyy.blog.modules.sys.entity.User;
import com.zyy.blog.modules.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;


@Controller
public class UserController<httpsession> {
    @Autowired
    UserService userService;
    @RequestMapping("/register")
    @ResponseBody
    public String register(@RequestBody User user) throws UnsupportedEncodingException, NoSuchAlgorithmException {
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        user.setUserRegisterTime(new Date());
//        Md5 md5=new Md5();
//        String userPass=md5.EncoderByMd5(user.getUserPass());
//        user.setUserPass(userPass);
        //所有的业务逻辑都放在service层处理
        userService.insert(user);
        return "成功";
    }

    @RequestMapping("/user")

    public String user() {
        return "modules/sys/user";
    }

    @RequestMapping("/login")

    public String login() {
        return "modules/sys/login";
    }

    @RequestMapping("/Dologin")
    @ResponseBody
    public Object Dologin(@RequestBody User user, HttpSession session) {
        User result= userService.login(user);
        if(user.getUserPass().equals(result.getUserPass()) && user.getUserName().equals(result.getUserName()) && result.getUserId()!=null)
            session.setAttribute(WebSecurityConfig.SESSION_KEY, result.getUserId());
        return session.getAttribute(WebSecurityConfig.SESSION_KEY);
    }

    @RequestMapping("/select")
    @ResponseBody
    public User select(@RequestBody User user) {
       User res= userService.select(user);
        return res;
    }
}
