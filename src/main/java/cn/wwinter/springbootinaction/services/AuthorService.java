package cn.wwinter.springbootinaction.services;


import cn.wwinter.springbootinaction.domain.dto.AuthorDto;
import cn.wwinter.springbootinaction.domain.entities.AuthorEntity;

import java.util.List;

/**
 * ClassName: AuthorService
 * Package: cn.wwinter.springbootinaction.services
 * Description:
 * Datetime: 2023/11/13
 * Author: zhangdd
 */
public interface AuthorService {
    AuthorEntity createAuthor(AuthorEntity authorEntity);

    List<AuthorDto> getAllAuthors();

}
