package com.hws.mall.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.hws.mall.enums.ResponseEnum;
import com.hws.mall.model.User;
import lombok.Data;
import org.springframework.validation.BindingResult;

import javax.xml.ws.Response;
import java.util.Objects;

/**
 * ClassName:ResponseVo
 * Package:com.hws.mall.vo
 * Description:
 *
 * @ date:2020/2/18 15:55
 * @ author:hws
 */
@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ResponseVo<T> {

    private Integer status;

    private String msg;

    private T data;

    public ResponseVo(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public ResponseVo(Integer status, T data) {
        this.status = status;
        this.data = data;
    }

    public static <T> ResponseVo<T> succcessByMsg(String msg) {
        return new ResponseVo<T>(ResponseEnum.SUCCESS_STATUS.getCode(), msg);
    }

    public static <T> ResponseVo<T> succcess(T data) {
        return new ResponseVo<T>(ResponseEnum.SUCCESS_STATUS.getCode(), data);
    }

    public static <T> ResponseVo<T> succcess() {
        return new ResponseVo<T>(ResponseEnum.SUCCESS_STATUS.getCode(), ResponseEnum.SUCCESS_STATUS.getMsg());
    }

    public static <T> ResponseVo<T> error(ResponseEnum responseEnum) {
        return new ResponseVo<T>(responseEnum.getCode(), responseEnum.getMsg());
    }

    public static <T> ResponseVo<T> error(ResponseEnum responseEnum, String msg) {
        return new ResponseVo<T>(responseEnum.getCode(), responseEnum.getMsg());
    }

    public static <T> ResponseVo<T> error(ResponseEnum responseEnum, BindingResult bindingResult) {
        return new ResponseVo<T>(responseEnum.getCode(), Objects.requireNonNull(bindingResult.getFieldError()).getField()
                + " " + bindingResult.getFieldError().getDefaultMessage());
    }


}
