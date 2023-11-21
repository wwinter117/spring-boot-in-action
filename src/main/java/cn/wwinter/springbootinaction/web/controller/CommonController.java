package cn.wwinter.springbootinaction.web.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * ClassName: CommonController
 * Package: cn.wwinter.springbootinaction.controller
 * Description:
 * Datetime: 2023/11/21
 * Author: zhangdd
 */
@Slf4j
@Controller
public class CommonController implements ErrorController {

    private final static String ERROR_PATH = "/error";

    @GetMapping(ERROR_PATH)
    public String handleError(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("jakarta.servlet.error.status_code");
        if (statusCode == 404) {
            return "common/404";
        } else {
            return "common/500";
        }
    }

}
