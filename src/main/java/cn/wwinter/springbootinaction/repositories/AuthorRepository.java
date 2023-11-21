package cn.wwinter.springbootinaction.repositories;

import cn.wwinter.springbootinaction.model.domain.AuthorEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * ClassName: AuthorRepository
 * Package: cn.wwinter.springbootinaction.database.repositories
 * Description:
 * Datetime: 2023/11/13
 * AuthorEntity: zhangdd
 */
@Repository
public interface AuthorRepository extends CrudRepository<AuthorEntity, Long> {

}
