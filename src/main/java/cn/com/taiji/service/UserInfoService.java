package cn.com.taiji.service;

import cn.com.taiji.domain.UserInfo;

/**
 * @Author: zxx
 * @Date: 2018/12/11 10:47
 * @Version 1.0
 */
public interface UserInfoService {
    /**
     * 根据用户名查找
     * @param username
     * @return
     */
    UserInfo findByUsername(String username);
}
