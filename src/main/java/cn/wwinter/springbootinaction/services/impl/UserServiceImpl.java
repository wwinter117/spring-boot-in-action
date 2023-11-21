package cn.wwinter.springbootinaction.services.impl;

import cn.wwinter.springbootinaction.model.domain.User;
import cn.wwinter.springbootinaction.repositories.UserRepository;
import cn.wwinter.springbootinaction.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName: UserServiceImpl
 * Package: cn.wwinter.springbootinaction.services.impl
 * Description:
 * Datetime: 2023/11/21
 * Author: zhangdd
 */
@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User userLogin(String username, String userpass) {
        return userRepository.findByUserNameAndUserPass(username, userpass);
    }
}
