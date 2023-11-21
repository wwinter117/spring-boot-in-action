package cn.wwinter.springbootinaction.web.controller;

import cn.wwinter.springbootinaction.model.dto.WwinterConst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName: AdminController
 * Package: cn.wwinter.springbootinaction.controller
 * Description:
 * Datetime: 2023/11/20
 * Author: zhangdd
 */
@Controller
@RequestMapping("/index")
@Slf4j
public class IndexController extends BaseController {

    @GetMapping
    public String index(Model model) {
        log.info("获取主页...");
        return this.index(model, 1);
    }

    @GetMapping("page/{page}")
    public String index(Model model, @PathVariable("page") Integer page) {

        model.addAttribute("posts", null);
        // 系统设置
        model.addAttribute("options", WwinterConst.OPTIONS);
        System.out.println("WwinterConst.OPTIONS = " + WwinterConst.OPTIONS);

        // 用户信息
        model.addAttribute("user", WwinterConst.USER);

        // 所有分类目录
        model.addAttribute("categories", null);

        // 归档数据
        model.addAttribute("archives", null);

        return this.render("index");
    }


}
