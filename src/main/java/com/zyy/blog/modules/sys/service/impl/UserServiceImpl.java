package com.zyy.blog.modules.sys.service.impl;

import com.zyy.blog.commons.utils.Md5;
import com.zyy.blog.modules.sys.dao.UserMapper;
import com.zyy.blog.modules.sys.entity.User;
import com.zyy.blog.modules.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;


    @Override
    public int insert(User user) {
        user.setUserRegisterTime(new Date());
        Md5 md5=new Md5();
        String userPass= null;
        try {
            userPass = md5.EncoderByMd5(user.getUserPass());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        user.setUserPass(userPass);
        return userMapper.insert(user);
    }

    @Override
    public User login(User user) {
        Md5 md5=new Md5();
        String userPass= null;
        try {
            userPass = md5.EncoderByMd5(user.getUserPass());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        user.setUserPass(userPass);
        User result=userMapper.selectByExample(user);
        return result;
    }

    public User select(User user){
        User result=userMapper.selectByExample(user);
        return result;
    }
}
