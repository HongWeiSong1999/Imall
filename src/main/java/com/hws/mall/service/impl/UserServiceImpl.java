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

        //4、放入数据库
        int registerUser = userDao.insertSelective(user);
        if(registerUser == 0){
            return ResponseVo.error(SERVICE_ERROR);
        }
        return ResponseVo.succcess();
    }
}
