package com.ncf.emc.web.conf;

import com.ncf.emc.common.result.ReturnCodeEnum;
import com.ncf.emc.common.util.BusinessException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;

/**
 * 类RestExceptionHandler.java的实现描述：x
 *
 * @author lixiaoyong 2017/8/3 16:18
 */
@Log4j2
@ControllerAdvice
public class GlobalExceptionHandler {


    @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        log.error("全局捕获异常-类型:{}", e.getClass().toString());
        log.error("全局捕获异常-信息:{}", e.getMessage());
        log.error("全局捕获异常-栈:{}", e.getStackTrace());

        Result result=new Result();


        String msg = null;
        if (e instanceof BusinessException) {
            BusinessException exception = (BusinessException) e;
            result.setCode(exception.getReturnCodeEnum().value());
            if (exception.getMessage() != null) {
                result.setMsg(exception.getReturnCodeEnum().getDesc() + "[" + exception.getMessage() + "]");
            } else {
                result.setMsg(exception.getReturnCodeEnum().getDesc());
            }
        } else if (e instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException ex = (MethodArgumentNotValidException) e;
            result.setCode(ReturnCodeEnum.RESTFUL_REQUEST_OBJECT_INVALID.value());
            result.setMsg(parseArgumentNotValid(ex.getBindingResult()));

        } else if (e instanceof HttpMessageNotReadableException) {
            HttpMessageNotReadableException ex = (HttpMessageNotReadableException) e;
            result.setCode(ReturnCodeEnum.RESTFUL_REQUEST_OBJECT_INVALID.value());
            result.setMsg(ex.getMessage());

        } else if (e instanceof BindException) {


        } else {
            result.setCode(ReturnCodeEnum.UNKNOWN_FAIL.value());
            result.setMsg(e.getMessage());
        }

        log.error("", e);

        return result;
    }

    private String parseArgumentNotValid(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<FieldError> fieldErrorList = bindingResult.getFieldErrors();
            StringBuilder errorSB = new StringBuilder();
            for (FieldError fieldError : fieldErrorList) {
                errorSB.append("[").append(fieldError.getField()).append(":").append(fieldError.getDefaultMessage()).append("]");
            }
            return errorSB.toString();
        }
        return "";
    }
}
