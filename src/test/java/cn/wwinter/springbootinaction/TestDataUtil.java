package cn.wwinter.springbootinaction;

import cn.wwinter.springbootinaction.database.domain.entities.AuthorEntity;
import cn.wwinter.springbootinaction.database.domain.entities.BookEntity;

/**
 * ClassName: TestDataUtil
 * Package: cn.wwinter.springbootinaction
 * Description:
 * Datetime: 2023/11/13
 * AuthorEntity: zhangdd
 */
public class TestDataUtil {
    public static AuthorEntity createAuthorA() {
        return AuthorEntity.builder()
                .id(1L)
                .name("alice")
                .age(18)
                .build();
    }
    public static AuthorEntity createAuthorB() {
        return AuthorEntity.builder()
                .id(2L)
                .name("Anna")
                .age(22)
                .build();
    }

    public static AuthorEntity createAuthorC() {
        return AuthorEntity.builder()
                .id(3L)
                .name("Jack")
                .age(24)
                .build();
    }

    public static BookEntity createBookA(final AuthorEntity author) {
        return BookEntity.builder()
                .isbn("874-2-6394-8")
                .title("Hello Java")
                .author(author)
                .build();
    }
    public static BookEntity createBookB(final AuthorEntity author) {
        return BookEntity.builder()
                .isbn("874-2-6394-8")
                .title("Hello C++")
                .author(author)
                .build();
    }
    public static BookEntity createBookC(final AuthorEntity author) {
        return BookEntity.builder()
                .isbn("874-2-6394-8")
                .title("Hello GoLang")
                .author(author)
                .build();
    }

}
