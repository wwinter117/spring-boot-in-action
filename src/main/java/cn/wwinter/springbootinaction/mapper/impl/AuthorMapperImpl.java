package cn.wwinter.springbootinaction.mapper.impl;

import cn.wwinter.springbootinaction.model.dto.*;
import cn.wwinter.springbootinaction.model.domain.*;
import cn.wwinter.springbootinaction.mapper.AuthorMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

/**
 * ClassName: AuthorMapperImpl
 * Package: cn.wwinter.springbootinaction.mapper.impl
 * Description:
 * Datetime: 2023/11/13
 * Author: zhangdd
 */
@Component
public class AuthorMapperImpl implements AuthorMapper {

    private final ModelMapper modelMapper;

    public AuthorMapperImpl(final ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public AuthorDto mapperTo(AuthorEntity authorEntity) {
        return modelMapper.map(authorEntity, AuthorDto.class);
    }

    @Override
    public AuthorEntity mapperFrom(AuthorDto authorDto) {
        return modelMapper.map(authorDto, AuthorEntity.class);
    }
}
