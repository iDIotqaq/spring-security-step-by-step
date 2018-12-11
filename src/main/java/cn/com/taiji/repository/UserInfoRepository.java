package cn.com.taiji.repository;

import cn.com.taiji.domain.UserInfo;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: zxx
 * @Date: 2018/12/11 10:45
 * @Version 1.0
 */
public interface UserInfoRepository extends JpaRepository<UserInfo,String> {
    /**
     * 根据用户名查找
     * @param username
     * @return
     */
    UserInfo findByUsername(String username);

}
