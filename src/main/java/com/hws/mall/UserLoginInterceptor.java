package com.hws.mall;

import com.hws.mall.exception.UserLoginException;
import com.hws.mall.model.User;
import com.hws.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static com.hws.mall.consts.MallConst.CURRENT_USER;
import static com.hws.mall.enums.ResponseEnum.NEED_LOGIN;

/**
 * ClassName:UserLoginInterceptor
 * Package:com.hws.mall
 * Description:
 *
 * @ date:2020/2/20 16:18
 * @ author:hws
 */
@Slf4j
public class UserLoginInterceptor implements HandlerInterceptor {

    /*
     * @ Author hongweisong
     * @ Description 拦截器
     * @ Points true表示继续执行，false表示中断
     * @ Date 16:28 2020/2/20
     * @ Param
     **/
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        log.info("preHandle..");
        //获取session
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(CURRENT_USER);
        //判断session中是否有用户数据，如果有，则返回true，继续向下执行;如果没有，返回false
        if (user == null) {
           // response.getWriter().print("error");
            // return false;
            throw new UserLoginException();
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
