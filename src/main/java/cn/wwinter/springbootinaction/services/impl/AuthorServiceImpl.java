package cn.wwinter.springbootinaction.services.impl;

import cn.wwinter.springbootinaction.domain.dto.AuthorDto;
import cn.wwinter.springbootinaction.domain.entities.AuthorEntity;
import cn.wwinter.springbootinaction.mapper.AuthorMapper;
import cn.wwinter.springbootinaction.mapper.Mapper;
import cn.wwinter.springbootinaction.repositories.AuthorRepository;
import cn.wwinter.springbootinaction.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    @Autowired
    private AuthorMapper authorMapper;


    @Override
    public AuthorEntity createAuthor(AuthorEntity authorEntity) {
        return authorRepository.save(authorEntity);
    }

    @Override
    public List<AuthorDto> getAllAuthors() {
        List<AuthorDto> authorDtoList = new ArrayList<>();
        for (AuthorEntity authorEntity : authorRepository.findAll()) {
            authorDtoList.add(authorMapper.mapperTo(authorEntity));
        }
        return authorDtoList;
    }
}
