package com.fcl.fblog.mapper;

import com.fcl.fblog.pojo.AdminUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminUserDao {
    List<AdminUser> findAdminUserByUserName(@Param("username") String username);
    public void updateInfo(AdminUser adminUser);
}
