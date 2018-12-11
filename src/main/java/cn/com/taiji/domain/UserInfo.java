package cn.com.taiji.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author: zxx
 * @Date: 2018/12/11 10:43
 * @Version 1.0
 */
@Entity
@Data
public class UserInfo {
    @Id
    @GeneratedValue
    private long uid;

    private String username;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    public enum Role{
        ROLE_ADMIN,ROLE_USER
    }
}
