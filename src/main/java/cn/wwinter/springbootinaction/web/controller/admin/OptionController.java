package cn.wwinter.springbootinaction.web.controller.admin;

import cn.wwinter.springbootinaction.model.dto.WwinterConst;
import cn.wwinter.springbootinaction.services.OptionService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ClassName: OptionController
 * Package: cn.wwinter.springbootinaction.controller.admin
 * Description:
 * Datetime: 2023/11/21
 * Author: zhangdd
 */
@Controller
@Slf4j
@AllArgsConstructor
@RequestMapping("/admin/option")
public class OptionController {

    private final OptionService optionService;

    @GetMapping
    public String options(Model model) {
        model.addAttribute("options", WwinterConst.OPTIONS);
        log.info("所有的设置选项："+WwinterConst.OPTIONS);
        return "admin/option";
    }

}
