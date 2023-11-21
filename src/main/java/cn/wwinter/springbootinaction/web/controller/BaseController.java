package cn.wwinter.springbootinaction.web.controller;

import cn.wwinter.springbootinaction.services.PostService;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * ClassName: BaseController
 * Package: cn.wwinter.springbootinaction.controller
 * Description:
 * Datetime: 2023/11/20
 * Author: zhangdd
 */
public abstract class BaseController {

    public static String THEME = "halo";

    @Autowired
    private PostService postService;

    public String render(String pageName) {
        return "themes/" + THEME + "/" + pageName;
    }

    protected void getNewPosts(HttpSession session) {
        session.setAttribute("postTopFive", postService.findPostsLatest());
    }
}
