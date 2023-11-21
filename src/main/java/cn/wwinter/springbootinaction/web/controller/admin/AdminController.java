package cn.wwinter.springbootinaction.web.controller.admin;

import cn.wwinter.springbootinaction.model.domain.User;
import cn.wwinter.springbootinaction.model.dto.RespStatus;
import cn.wwinter.springbootinaction.services.LogService;
import cn.wwinter.springbootinaction.services.UserService;
import cn.wwinter.springbootinaction.web.controller.BaseController;
import cn.wwinter.springbootinaction.model.domain.Logs;
import cn.wwinter.springbootinaction.model.domain.Post;
import cn.wwinter.springbootinaction.model.dto.WwinterConst;
import cn.wwinter.springbootinaction.services.PostService;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ClassName: AdminController
 * Package: cn.wwinter.springbootinaction.controller
 * Description:
 * Datetime: 2023/11/16
 * Author: zhangdd
 */
@Controller
@RequestMapping("admin")
@AllArgsConstructor
@Slf4j
public class AdminController extends BaseController {

    private final PostService postService;
    private final LogService logsService;
    private final UserService userService;

    /**
     * 后台首页
     */
    @GetMapping(value = {"","/index"})
    public String index(Model model, HttpSession httpSession) {

        Integer postCount = postService.findAllPosts().size();
        model.addAttribute("postCount", postCount);

        List<Post> postsLatest = postService.findPostsLatest();
        model.addAttribute("postTopFive", postsLatest);
        model.addAttribute("options", WwinterConst.OPTIONS);
        model.addAttribute("mediaCount", WwinterConst.ATTACHMENTS.size());

        List<Logs> logsLatest = logsService.findLogsLatest();
        model.addAttribute("logs", logsLatest);
        this.getNewPosts(httpSession);
        return "admin/index";
    }

    /**
     * 登录页面
     */
    @GetMapping("/login")
    public String login(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user != null) {
            return "redirect:/admin";
        }
        return "admin/login";
    }

    /**
     * 验证登录信息
     */
    @PostMapping("/getLogin")
    @ResponseBody
    public String getLogin(@ModelAttribute("loginName") String loginName,
                           @ModelAttribute("loginPwd") String loginPwd,
                           HttpSession session) {
        try {
            User user = userService.userLogin(loginName, loginPwd);
            if (user != null) {
                log.info("用户：[{}] 登陆成功", loginName);
                session.setAttribute("user", user);
                return RespStatus.SUCCESS;
            } else {
                log.info("用户：[{}] 登陆失败", loginName);
            }
        } catch (Exception e) {
            log.error("登录失败！：" + e.getMessage());
        }
        return RespStatus.ERROR;
    }




}
