package cn.wwinter.springbootinaction.repositories;

import cn.wwinter.springbootinaction.model.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * ClassName: UserRepository
 * Package: cn.wwinter.springbootinaction.repositories
 * Description:
 * Datetime: 2023/11/21
 * Author: zhangdd
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUserNameAndUserPass(String username, String userpass);

}
