package cn.com.taiji.config;

import cn.com.taiji.support.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Author: zxx
 * @Date: 2018/12/11 9:45
 * @Version 1.0
 * 开启方法注解权限验证
 * @EnableGlobalMethodSecurity(配置开启哪些注解配置)
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private CustomUserDetailService customUserDetailService;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //加入自定义UserDetailService
        auth.userDetailsService(customUserDetailService).passwordEncoder(passwordEncoder());
/*        auth.inMemoryAuthentication()
                //.passwordEncoder() 配置加密方式
                .withUser("a")
                .password(passwordEncoder().encode("123"))
                .roles("ADMIN","USER");
        auth.inMemoryAuthentication()
                .withUser("b")
                .password(passwordEncoder().encode("456"))
                .roles("USER");*/
    }

    /**
     * 注入方式配置加密方式
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage("/login")
                .and()
                .authorizeRequests()
                .antMatchers("/","/login","/index").permitAll()
                .anyRequest().authenticated();
    }


}
