package cn.wwinter.springbootinaction.services;

import cn.wwinter.springbootinaction.model.domain.User;

import java.util.List;

/**
 * ClassName: UserService
 * Package: cn.wwinter.springbootinaction.services
 * Description:
 * Datetime: 2023/11/21
 * Author: zhangdd
 */
public interface UserService {
    List<User> findAllUsers();

    User userLogin(String username, String userpass);
}
