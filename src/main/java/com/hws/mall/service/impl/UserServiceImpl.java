package com.hws.mall.service.impl;

import com.hws.mall.dao.UserDao;
import com.hws.mall.enums.ResponseEnum;
import com.hws.mall.model.User;
import com.hws.mall.service.IUserService;
import com.hws.mall.vo.ResponseVo;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;

import static com.hws.mall.enums.ResponseEnum.*;

/**
 * ClassName:UserServiceImpl
 * Package:com.hws.mall.service.impl
 * Description:
 *
 * @ date:2020/2/19 15:11
 * @ author:hws
 */
@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private UserDao userDao;

    /**
     * @ Author hongweisong
     * @ Description 用户注册功能
     * @ Points 判断用户名、密码是否存在，传进来的密码先加密再和数据库里面进行对比，最后再传入数据库中
     * @ Date 19:54 2020/2/19
     * @ Param [user]
     **/
    @Override
    public ResponseVo<User> registerUser(User user) {
        //1、判断用户名在数据库中是否存在
        int countByUsername = userDao.countByUsername(user.getUsername());
        if( countByUsername > 0){
            return ResponseVo.error(USERNAME_EXIT);
        }

        //2、判断邮箱是否存在
        int countByEmail = userDao.countByEmail(user.getEmail());
        if(countByEmail > 0){
            return ResponseVo.error(EMAIL_EXIT);
        }

        //3、对密码进行md5加密
        user.setPassword(DigestUtils.md5DigestAsHex
                (user.getPassword().getBytes(StandardCharsets.UTF_8)));

        //4、开始的时候先对role进行赋值
        user.setRole(1);

        //5、放入数据库
        int registerUser = userDao.insertSelective(user);
        if(registerUser == 0){
            return ResponseVo.error(SERVICE_ERROR);
        }
        return ResponseVo.succcess();
    }

    /**
     * @ Author hongweisong
     * @ Description 用户登录
     * @ Points
     * @ Date 19:57 2020/2/19
     * @ Param [username, password]
     **/
    @Override
    public ResponseVo<User> userLogin(String username, String password) {

        //1、先通过username查出数据库中的User类
        User user = userDao.selectByUsername(username);

        //2、如果通过用户名差不到用户的话，就提示用户名或密码错误
        if(user == null){
            return ResponseVo.error(USERNAME_OR_PASSWORD_ERROR);
        }

        /*3、输入的密码进行加密后 和数据库里的密码进行比较，并且比较的时候忽略大小写
         如果错误的话，返回用户名或者密码错误*/
        boolean passwordIsTrue = user.getPassword().equalsIgnoreCase
                (DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8)));
        if(!passwordIsTrue){
            return ResponseVo.error(USERNAME_OR_PASSWORD_ERROR);
        }
        //4、返回的时候，会有密码也显示出来，这个地方的话，就给他设置为一个空的密码就好了
        user.setPassword("");

        return ResponseVo.succcess(user);
    }
}
