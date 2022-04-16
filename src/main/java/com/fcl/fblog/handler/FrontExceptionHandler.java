package com.fcl.fblog.handler;


import com.fcl.fblog.exception.FrontBusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 前台业务异常处理器
 */
@ControllerAdvice
public class FrontExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 业务异常处理
     *
     * @param e 业务异常
     * @return
     */
    @ExceptionHandler(value = FrontBusinessException.class)
    public ModelAndView exceptionHandler(HttpServletRequest request, FrontBusinessException e) {
        logger.error("Request URL : {}, Exception : {}",request.getRequestURL(),e.getErrorMsg());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("url",request.getRequestURL());
        modelAndView.addObject("exception", e);
        modelAndView.setViewName("error/error");
        return modelAndView;
    }

    /**
     * 未知异常处理
     */
//    @ExceptionHandler(value = Exception.class)
//    public ModelAndView exceptionHandler(Exception e) {
//        // 把错误信息输入到日志中
//        log.error(ErrorUtil.errorInfoToString(e));
//        return ApiResponse.error(ExceptionEnum.UNKNOWN.getCode(),
//                ExceptionEnum.UNKNOWN.getMsg());
//    }

    /**
     * 错误页面异常
     */
//    @ExceptionHandler(value = ErrorPageException.class)
//    public ModelAndView exceptionHandler(ErrorPageException e) {
//        log.error(ErrorUtil.errorInfoToString(e));
//        return ApiResponse.error(e.getCode(), e.getErrorMsg());
//    }

    /**
     * 空指针异常
     */
//    @ExceptionHandler(value = NullPointerException.class)
//    public ModelAndView exceptionHandler(NullPointerException e) {
//        log.error(ErrorUtil.errorInfoToString(e));
//        return ApiResponse.error(ExceptionEnum.INTERNAL_SERVER_ERROR.getCode(),
//                ExceptionEnum.INTERNAL_SERVER_ERROR.getMsg());
//    }
}
