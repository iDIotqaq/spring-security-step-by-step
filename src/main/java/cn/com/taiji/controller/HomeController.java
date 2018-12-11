package cn.com.taiji.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: zxx
 * @Date: 2018/12/11 14:12
 * @Version 1.0
 */
@Controller
public class HomeController {
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping({"","/","/index"})
    public String index(){
        return "index";
    }}
