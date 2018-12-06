package com.zyy.blog.modules.sys.controller;

import com.zyy.blog.commons.config.WebSecurityConfig;
import com.zyy.blog.commons.utils.IpUtil;
import com.zyy.blog.commons.utils.Md5;
import com.zyy.blog.commons.utils.R;
import com.zyy.blog.modules.sys.entity.User;
import com.zyy.blog.modules.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class UserController<httpsession> {
    @Autowired
    UserService userService;
    @RequestMapping("/register")
    @ResponseBody
    public String register(@RequestBody User user){
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
    public R Dologin(@RequestBody User user, HttpSession session, HttpServletRequest request) {
        Md5 md5=new Md5();
        String userPass= null;
        try {
            userPass = md5.EncoderByMd5(user.getUserPass());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        User result= userService.login(user);
        if(result!=null){
            System.out.print(result.getUserPass());
            System.out.print(userPass);
            if (result.getUserPass().equals(userPass)){
                //获取用户登录ip
                result.setUserLastLoginIp(IpUtil.getIpAddr(request));
                result.setUserLastLoginTime(new Date());
                result.setUserStatus(1);
                userService.updateUser(result);
                session.setAttribute(WebSecurityConfig.SESSION_KEY, result.getUserId());
                Map<String, Object> map = new HashMap();
                map.put("userId",session.getAttribute(WebSecurityConfig.SESSION_KEY));
                return R.ok().put("data",map);
            }else{
                return R.error(200,"密码错误");
            }
        }else{
            return R.error(200,"用户名不存在");
        }
    }

    @RequestMapping("/selectAllUser")
    @ResponseBody
    public R selectAllUser(User user) {
        List<User> result = userService.selectAllUser(user);
       if(result!=null){
           return R.ok().put("data",result);
       }else{
           return R.error(200,"暂无用户列表");
       }
    }
}
