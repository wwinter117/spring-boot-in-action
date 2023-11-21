package cn.wwinter.springbootinaction.services;

import cn.wwinter.springbootinaction.model.domain.Post;

import java.util.Collection;
import java.util.List;

/**
 * ClassName: PostService
 * Package: cn.wwinter.springbootinaction.services
 * Description:
 * Datetime: 2023/11/21
 * Author: zhangdd
 */
public interface PostService {
    List<Post> findAllPosts();

    List<Post> findPostsLatest();
}
