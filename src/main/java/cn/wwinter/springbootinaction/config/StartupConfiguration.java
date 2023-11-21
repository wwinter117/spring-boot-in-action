package cn.wwinter.springbootinaction.config;

import cn.wwinter.springbootinaction.web.controller.BaseController;
import cn.wwinter.springbootinaction.model.domain.Attachment;
import cn.wwinter.springbootinaction.model.domain.User;
import cn.wwinter.springbootinaction.model.dto.WwinterConst;
import cn.wwinter.springbootinaction.services.AttachmentService;
import cn.wwinter.springbootinaction.services.OptionService;
import cn.wwinter.springbootinaction.services.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.List;
import java.util.Map;

/**
 * ClassName: StartupConfiguration
 * Package: cn.wwinter.springbootinaction.config
 * Description:
 * Datetime: 2023/11/20
 * Author: zhangdd
 */
@AllArgsConstructor
@Configuration
@Slf4j
public class StartupConfiguration implements ApplicationListener<ContextRefreshedEvent> {

    private final OptionService optionService;

    private final UserService userService;

    private final AttachmentService attachmentService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        this.loadOptions();
        this.loadActiveTheme();
        this.loadUser();
        this.loadAttachment();
    }

    /**
     * 加载系统配置
     */
    public void loadOptions() {
        try {
            log.info("【开始加载系统配置...】");
            Map<String, String> options = optionService.findAllOptions();
            if (options != null && !options.isEmpty()) {
                WwinterConst.OPTIONS = options;
            }
            log.info("系统配置加载完毕: options = {}", options);
        } catch (Exception e) {
            log.error("未知错误: " + e.getMessage());
        }
    }

    /**
     * 加载主题
     */
    public void loadActiveTheme() {
        try {
            log.info("【开始加载主题...】");
            String theme = optionService.findOneOption("theme");
            if (theme != null && !theme.isEmpty()) {
                BaseController.THEME = theme;
            }
            log.info("主题加载完毕: theme = {}", theme);
        } catch (Exception e) {
            log.error("未知错误: " + e.getMessage());
        }
    }

    /**
     * 加载用户
     */
    public void loadUser() {
        try {
            log.info("【开始加载用户...】");
            User user = userService.findAllUsers().get(0);
            if (user != null) {
                WwinterConst.USER = user;
            }
            log.info("用户加载完毕: user = {}", user);
        } catch (Exception e) {
            log.error("未知错误: " + e.getMessage());
        }
    }

    /**
     * 加载文件
     */
    public void loadAttachment() {
        try {
            log.info("【开始加载文件...】");
            List<Attachment> attachments = attachmentService.findAllAttachments();
            if (attachments != null && !attachments.isEmpty()) {
                WwinterConst.ATTACHMENTS = attachments;
            }
            log.info("文件加载完毕: attachments = {}", attachments);
        } catch (Exception e) {
            log.error("未知错误: " + e.getMessage());
        }
    }

}
