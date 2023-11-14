package cn.wwinter.springbootinaction.services.impl;

import cn.wwinter.springbootinaction.database.domain.entities.AuthorEntity;
import cn.wwinter.springbootinaction.database.repositories.AuthorRepository;
import cn.wwinter.springbootinaction.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassName: AuthorServiceImpl
 * Package: cn.wwinter.springbootinaction.services.impl
 * Description:
 * Datetime: 2023/11/13
 * Author: zhangdd
 */
@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorRepository authorRepository;


    @Override
    public AuthorEntity createAuthor(AuthorEntity authorEntity) {
        return authorRepository.save(authorEntity);
    }
}
