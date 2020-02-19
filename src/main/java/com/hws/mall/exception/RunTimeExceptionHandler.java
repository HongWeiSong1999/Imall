package com.hws.mall.exception;

import com.hws.mall.enums.ResponseEnum;
import com.hws.mall.vo.ResponseVo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * ClassName:RunTimeExceptionHandler
 * Package:com.hws.mall.exception
 * Description:
 *
 * @ date:2020/2/18 21:14
 * @ author:hws
 */
@ControllerAdvice
public class RunTimeExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    //@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public ResponseVo handle(RuntimeException e){
        return ResponseVo.error(ResponseEnum.SERVICE_ERROR, e.getMessage());
    }
}
