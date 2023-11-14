package cn.wwinter.springbootinaction.mapper.impl;

import cn.wwinter.springbootinaction.domain.dto.*;
import cn.wwinter.springbootinaction.domain.entities.*;
import cn.wwinter.springbootinaction.mapper.Mapper;
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
public class AuthorMapperImpl implements Mapper<AuthorEntity, AuthorDto> {

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
