package cn.com.taiji.support;

import cn.com.taiji.domain.UserInfo;
import cn.com.taiji.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zxx
 * @Date: 2018/12/11 10:51
 * @Version 1.0
 */
@Component
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private UserInfoService userInfoService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //根据用户名查询用户
        UserInfo userInfo = userInfoService.findByUsername(username);
        //判断用户是否存在
        if(userInfo==null){
            throw new UsernameNotFoundException("找不到"+username+"用户");
        }
        //查询密码
        String password = userInfo.getPassword();
        //初始化权限列表
        List<GrantedAuthority> authorities = new ArrayList<>();
        //查询权限
        GrantedAuthority authority = new SimpleGrantedAuthority(userInfo.getRole().name());
        //插入权限
        authorities.add(authority);
        //返回UserDetails
        UserDetails user = new User(username,password,authorities);
        return user;
    }
}
