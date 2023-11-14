package cn.wwinter.springbootinaction.services;

import cn.wwinter.springbootinaction.database.domain.entities.AuthorEntity;

/**
 * ClassName: AuthorService
 * Package: cn.wwinter.springbootinaction.services
 * Description:
 * Datetime: 2023/11/13
 * Author: zhangdd
 */
public interface AuthorService {
    AuthorEntity createAuthor(AuthorEntity authorEntity);
}
