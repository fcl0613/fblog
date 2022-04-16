package com.fcl.fblog.service;

import com.fcl.fblog.pojo.AdminUser;


public interface AdminUserService {
    public AdminUser verifyPassword(String username, String password);
    public void updatePsd(String oldpsd, String newpsd, String agapsd, AdminUser adminUser);
}
