package cn.com.taiji;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
/**
 * 排除扫描包
 * exclude=xxxx.class
 * @SpringBootApplication(exclude = SecurityAutoConfiguration.class)
 */
@SpringBootApplication
public class SpringSecurityStepByStepApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityStepByStepApplication.class, args);
    }
}
