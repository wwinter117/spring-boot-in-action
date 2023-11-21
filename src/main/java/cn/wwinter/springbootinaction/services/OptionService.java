package cn.wwinter.springbootinaction.services;

import java.util.Map;

/**
 * ClassName: OptionService
 * Package: cn.wwinter.springbootinaction.services
 * Description:
 * Datetime: 2023/11/20
 * Author: zhangdd
 */
public interface OptionService {
    String findOneOption(String theme);

    Map<String, String> findAllOptions();
}
