package cn.wwinter.springbootinaction.services;


import cn.wwinter.springbootinaction.model.dto.AuthorDto;
import cn.wwinter.springbootinaction.model.domain.AuthorEntity;

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
