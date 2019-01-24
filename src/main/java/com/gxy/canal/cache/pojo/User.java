package com.gxy.canal.cache.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {
    /**
     * 用户id
     */
    private Long userId;

    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 用户名称
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户手机号
     */
    private String phone;

    /**
     * 用户剩余金额
     */
    private Integer money;

    /**
     * 是否激活 1为激活0为未激活
     */
    private Byte active;

    /**
     * 冻结资金
     */
    private Integer freezeMoney;
}

