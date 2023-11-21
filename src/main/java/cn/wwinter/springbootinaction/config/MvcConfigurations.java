package cn.wwinter.springbootinaction.config;

import cn.wwinter.springbootinaction.web.LoginInterceptor;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * ClassName: MvcConfigurations
 * Package: cn.wwinter.springbootinaction.config
 * Description:
 * Datetime: 2023/11/21
 * Author: zhangdd
 */
@Configuration
@AllArgsConstructor
@EnableWebMvc
public class MvcConfigurations implements WebMvcConfigurer {

    private final LoginInterceptor loginInterceptor;

    /**
     * 拦截/admin路径下的所有请求，除了/admin/login和/admin/getLogin
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/admin/**")
                .excludePathPatterns("/admin/login")
                .excludePathPatterns("/admin/getLogin");
    }

    /**
     * 配置静态资源路径
     * @param registry registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");

        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/templates/themes/")
                .addResourceLocations("classpath:/robots.txt");

        registry.addResourceHandler("/upload/**")
                .addResourceLocations("classpath:/upload/");
    }
}
