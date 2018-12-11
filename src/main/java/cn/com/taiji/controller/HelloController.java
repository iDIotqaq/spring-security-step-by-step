package cn.com.taiji.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zxx
 * @Date: 2018/12/11 9:34
 * @Version 1.0
 */
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String Hello(){
        return "hello world";
    }
    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String HelloAdmin(){
        return "hello Admin";
    }
    @GetMapping("/user")
    @PreAuthorize("hasAnyRole('USER')")
    public String HelloUser(){
        return "hello User";
    }
}
