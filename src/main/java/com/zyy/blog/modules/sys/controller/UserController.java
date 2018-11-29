package com.zyy.blog.modules.sys.controller;

import com.zyy.blog.modules.sys.entity.User;
import com.zyy.blog.modules.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping("/register")
    @ResponseBody
    public String register(@RequestBody User user)  {
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        user.setUserRegisterTime(new Date());
//        Md5 md5=new Md5();
//        String userPass=md5.EncoderByMd5(user.getUserPass());
//        user.setUserPass(userPass);
        //所有的业务逻辑都放在service层处理
        userService.insert(user);
        return "成功";
    }

    @RequestMapping("/index")
    public String login() {
        return "modules/sys/index";
    }

}
