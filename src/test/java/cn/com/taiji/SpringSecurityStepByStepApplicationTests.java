package cn.com.taiji;

import cn.com.taiji.repository.UserInfoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringSecurityStepByStepApplicationTests {
    @Autowired
    private UserInfoRepository userInfoRepository;

    @Test
    public void contextLoads() {


    }

}
