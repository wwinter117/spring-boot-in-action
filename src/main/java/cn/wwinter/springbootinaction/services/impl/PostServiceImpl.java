package cn.wwinter.springbootinaction.services.impl;

import cn.wwinter.springbootinaction.model.domain.Post;
import cn.wwinter.springbootinaction.repositories.PostRepository;
import cn.wwinter.springbootinaction.services.PostService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName: PostServiceImpl
 * Package: cn.wwinter.springbootinaction.services.impl
 * Description:
 * Datetime: 2023/11/21
 * Author: zhangdd
 */
@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    @Override
    public List<Post> findAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public List<Post> findPostsLatest() {
        return postRepository.findTopFive();
    }

}
