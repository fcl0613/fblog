package com.fcl.fblog.controller;

import com.fcl.fblog.common.CodeConstant;
import com.fcl.fblog.common.MessageConstant;
import com.fcl.fblog.entity.LayuiResult;
import com.fcl.fblog.exception.BackendBusinessException;
import com.fcl.fblog.pojo.AdminUser;
import com.fcl.fblog.service.AdminUserService;
import com.wf.captcha.utils.CaptchaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 管理员登录
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminUserService adminUserService;

    @PostMapping("/updatepassword")
    @ResponseBody
    public LayuiResult updatePassword(@RequestParam("old_password") String oldpsd,
                                      @RequestParam("new_password") String newpsd,
                                      @RequestParam("again_password") String agapsd,
                                      HttpServletRequest request){
        try {
            AdminUser admin = (AdminUser) request.getSession().getAttribute("admin");
//            System.out.println(admin);
            adminUserService.updatePsd(oldpsd,newpsd,agapsd,admin);
            request.getSession().removeAttribute("admin");
            return LayuiResult.success(MessageConstant.UPDATE_PASSWORD_SUCCESS);
        } catch (BackendBusinessException e) {
            return LayuiResult.fail(e.getErrorMsg());
        }
    }

    @RequestMapping("/logout")
    @ResponseBody
    public LayuiResult logout(HttpServletRequest request){
        request.getSession().removeAttribute("admin");
        return  LayuiResult.success(MessageConstant.LOGOUT_SUCCESS);
    }

    /**
     * 管理员登录
     * @param userName
     * @param password
     * @param captcha
     * @param request
     * @return
     */
    @PostMapping("/dologin")
    @ResponseBody
    public LayuiResult doLogin(@RequestParam("username") String userName,
                               @RequestParam("password") String password,
                               @RequestParam("captcha") String captcha,
                               HttpServletRequest request){
        //验证码检验
        if (!CaptchaUtil.ver(captcha, request)) {
            CaptchaUtil.clear(request);  // 清除session中的验证码
            return LayuiResult.fail("验证码错误");
        }
        try {
            AdminUser adminUser = adminUserService.verifyPassword(userName, password);
            request.getSession().setAttribute("admin",adminUser);
            return new LayuiResult(CodeConstant.SUCCESS_CODE, MessageConstant.LOGIN_SUCCESS,null,adminUser);
        } catch (BackendBusinessException e) {
            e.printStackTrace();
            return new LayuiResult(e.getCode(), e.getErrorMsg(),null, null);
        }
    }
}
