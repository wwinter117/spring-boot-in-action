package cn.wwinter.springbootinaction.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName: MapperConfig
 * Package: cn.wwinter.springbootinaction.config
 * Description:
 * Datetime: 2023/11/13
 * Author: zhangdd
 */
@Configuration
public class MapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
