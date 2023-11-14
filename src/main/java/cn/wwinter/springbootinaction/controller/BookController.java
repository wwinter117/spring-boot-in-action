package cn.wwinter.springbootinaction.controller;

import cn.wwinter.springbootinaction.domain.dto.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: BookController
 * Package: cn.wwinter.springbootinaction.controller
 * Description:
 * Datetime: 2023/11/13
 * AuthorEntity: zhangdd
 */
@RestController
@Slf4j
public class BookController {

    @GetMapping("books")
    public BookDto getBook() {
        return BookDto.builder()
                .isbn("122-1-3434-2")
                .title("English BookDto")
                .author("anna")
                .build();
    }

    @PostMapping("createBook")
    public BookDto createBook(@RequestBody final BookDto bookDto) {
        log.info("Got BookDto: " + bookDto.toString());
        return bookDto;
    }
}
