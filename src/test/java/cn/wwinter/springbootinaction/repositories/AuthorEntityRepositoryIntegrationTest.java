package cn.wwinter.springbootinaction.repositories;

import cn.wwinter.springbootinaction.TestDataUtil;
import cn.wwinter.springbootinaction.domain.entities.AuthorEntity;
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
public class AuthorEntityRepositoryIntegrationTest {

    @Autowired
    private AuthorRepository underTest;

    @Test
    public void testThatAuthorCanBeCreatedAndRecalled() {
        AuthorEntity author = TestDataUtil.createAuthorA();

        underTest.save(author);

        Optional<AuthorEntity> result = underTest.findById(author.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(author);
    }

    @Test
    public void testThatMultipleCreateAuthorAndRecall() {
        AuthorEntity authorA = TestDataUtil.createAuthorA();
        AuthorEntity authorB = TestDataUtil.createAuthorB();
        AuthorEntity authorC = TestDataUtil.createAuthorC();
        underTest.save(authorA);
        underTest.save(authorB);
        underTest.save(authorC);

        Iterable<AuthorEntity> result = underTest.findAll();
        result.forEach(System.out::println);
        assertThat(result)
                .hasSize(3)
                .containsExactly(authorA, authorB, authorC);
    }
}
