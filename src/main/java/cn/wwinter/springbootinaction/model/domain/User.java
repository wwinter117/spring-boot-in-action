package cn.wwinter.springbootinaction.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;

/**
 * ClassName: User
 * Package: cn.wwinter.springbootinaction.domain.domain
 * Description:
 * Datetime: 2023/11/21
 * Author: zhangdd
 */
@Data
@Entity
@Table(name = "t_user")
public class User implements Serializable {
    /**
     * 编号
     */
    @Id
    @GeneratedValue
    private Integer userId;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 显示名称
     */
    private String userDisplayName;
    /**
     * 密码
     */
    private String userPass;
    /**
     * 邮箱
     */
    private String userEmail;
    /**
     * 头像
     */
    private String userAvatar;
    /**
     * 说明
     */
    private String userDesc;
}
