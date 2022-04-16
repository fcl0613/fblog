package com.fcl.fblog.handler;

import com.fcl.fblog.entity.LayuiResult;
import com.fcl.fblog.exception.BackendBusinessException;
import com.fcl.fblog.exception.FrontBusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 后台业务异常处理器
 */
@ControllerAdvice
public class BackendExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 后台业务异常处理
     *
     * @param e 业务异常
     * @return
     */
    @ExceptionHandler(value = BackendBusinessException.class)
    @ResponseBody
    public LayuiResult exceptionHandler(HttpServletRequest request, FrontBusinessException e) {
        logger.error("Request URL : {}, Exception : {}",request.getRequestURL(),e.getErrorMsg());
        return LayuiResult.fail(e.getCode(), e.getErrorMsg());
    }

    /**
     * 未知异常处理
     */
//    @ExceptionHandler(value = BackendBusinessException.class)
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
