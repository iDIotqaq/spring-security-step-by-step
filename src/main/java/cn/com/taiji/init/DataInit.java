package cn.com.taiji.init;

import cn.com.taiji.domain.UserInfo;
import cn.com.taiji.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @Author: zxx
 * @Date: 2018/12/11 11:04
 * @Version 1.0
 */
@Service
public class DataInit {
    @Autowired
    private UserInfoRepository userInfoRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void dataInit(){
        UserInfo admin = new UserInfo();
        admin.setPassword(passwordEncoder.encode("123"));
        admin.setUsername("a");
        admin.setRole(UserInfo.Role.ROLE_ADMIN);
        userInfoRepository.save(admin);

        UserInfo user = new UserInfo();
        user.setPassword(passwordEncoder.encode("456"));
        user.setUsername("b");
        user.setRole(UserInfo.Role.ROLE_USER);
        userInfoRepository.save(user);
    }
}
