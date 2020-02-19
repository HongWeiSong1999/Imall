package com.hws.mall.service;

import com.hws.mall.model.User;
import com.hws.mall.vo.ResponseVo;

/**
 * ClassName:UserService
 * Package:com.hws.mall.service
 * Description:
 *
 * @ date:2020/2/19 15:09
 * @ author:hws
 */
public interface IUserService {
    ResponseVo<User> registerUser(User user);

    ResponseVo<User> loginUser(String username, String password);
}
