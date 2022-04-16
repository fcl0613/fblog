package com.fcl.fblog.service.impl;

import com.fcl.fblog.common.CodeConstant;
import com.fcl.fblog.common.MessageConstant;
import com.fcl.fblog.common.enums.ExceptionEnum;
import com.fcl.fblog.entity.LayuiResult;
import com.fcl.fblog.exception.BackendBusinessException;
import com.fcl.fblog.mapper.AdminUserDao;
import com.fcl.fblog.pojo.AdminUser;
import com.fcl.fblog.service.AdminUserService;
import com.fcl.fblog.utils.MD5Utile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Autowired
    private AdminUserDao adminUserDao;

    /**
     * 管理员登录
     * @param username
     * @param password
     * @return
     */
    @Override
    public AdminUser verifyPassword(String username, String password) {
        List<AdminUser> adminUserList = adminUserDao.findAdminUserByUserName(username);
        if (adminUserList.size() > 1){
            throw new BackendBusinessException(CodeConstant.FAIL_CODE, MessageConstant.DB_INFO_ERROR);
        }
        if (adminUserList == null || adminUserList.size() == 0){
            throw new BackendBusinessException(CodeConstant.FAIL_CODE, MessageConstant.LOGIN_FAIL);
        }
        AdminUser adminUser = adminUserList.get(0);
        String md5password = MD5Utile.md5(password);
        if (!adminUser.getPassword().equals(md5password)){
            throw new BackendBusinessException(CodeConstant.FAIL_CODE, MessageConstant.USERNAME_PASSWORD_ERROR);
        }
        adminUser.setPassword(md5password);
        return adminUser;
    }

    @Override
    @Transactional
    public void updatePsd(String oldpsd, String newpsd, String agapsd, AdminUser adminUser) {
        String password = adminUser.getPassword();
        if (!password.equals(MD5Utile.md5(oldpsd))){
            throw new BackendBusinessException(CodeConstant.FAIL_CODE, MessageConstant.OLD_PASSWORD_ERROR);
        }
        if (!newpsd.equals(agapsd)){
            throw new BackendBusinessException(CodeConstant.FAIL_CODE, MessageConstant.INCONSISTENT_PASSWORD_TWICE);
        }
        String newPassword = MD5Utile.md5(newpsd);
        adminUser.setPassword(newPassword);
        adminUserDao.updateInfo(adminUser);
    }
}
