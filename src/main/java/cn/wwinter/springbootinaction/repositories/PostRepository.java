package cn.wwinter.springbootinaction.repositories;

import cn.wwinter.springbootinaction.model.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ClassName: PostRepository
 * Package: cn.wwinter.springbootinaction.repositories
 * Description:
 * Datetime: 2023/11/21
 * Author: zhangdd
 */
@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    @Query(value = "SELECT * FROM t_post ORDER BY post_id DESC LIMIT 5",nativeQuery = true)
    List<Post> findTopFive();
}
