package cn.wwinter.springbootinaction.repositories;

import cn.wwinter.springbootinaction.TestDataUtil;
import cn.wwinter.springbootinaction.database.domain.entities.AuthorEntity;
import cn.wwinter.springbootinaction.database.domain.entities.BookEntity;
import cn.wwinter.springbootinaction.database.repositories.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * ClassName: AuthorEntityRepositoryIntegrationTest
 * Package: cn.wwinter.springbootinaction.database.repositories
 * Description:
 * Datetime: 2023/11/13
 * AuthorEntity: zhangdd
 */
@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BookDtoRepositoryIntegrationTest {

    @Autowired
    private BookRepository underTest;

    @Test
    public void testThatAuthorCanBeCreatedAndRecalled() {
        AuthorEntity author = TestDataUtil.createAuthorA();

        BookEntity book = TestDataUtil.createBookA(author);

        underTest.save(book);

        Optional<BookEntity> result = underTest.findById(book.getIsbn());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(book);
    }
}
