package cn.wwinter.springbootinaction.web.controller.admin;

import cn.wwinter.springbootinaction.model.dto.*;
import cn.wwinter.springbootinaction.model.domain.*;
import cn.wwinter.springbootinaction.mapper.Mapper;
import cn.wwinter.springbootinaction.services.AuthorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ClassName: BookController
 * Package: cn.wwinter.springbootinaction.controller
 * Description:
 * Datetime: 2023/11/13
 * AuthorEntity: zhangdd
 */
@RestController
@Slf4j
public class AuthorController {

    private final AuthorService authorService;
    private final Mapper<AuthorEntity, AuthorDto> authorMapper;


    public AuthorController(AuthorService authorService, Mapper<AuthorEntity, AuthorDto> authorMapper) {
        this.authorService = authorService;
        this.authorMapper = authorMapper;
    }

    @PostMapping("author/createAuthor")
    public ResponseEntity<AuthorDto> createAuthor(@RequestBody final AuthorDto authorDto) {
        log.info("Got AuthorDto: " + authorDto.toString());
        AuthorEntity authorEntity = authorMapper.mapperFrom(authorDto);
        AuthorEntity saved = authorService.createAuthor(authorEntity);
        return new ResponseEntity<>(authorMapper.mapperTo(saved), HttpStatus.CREATED);
    }

    @GetMapping("author/authors")
    public List<AuthorDto> authors() {
        return authorService.getAllAuthors();
    }

}
