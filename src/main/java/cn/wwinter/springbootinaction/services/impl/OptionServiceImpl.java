package cn.wwinter.springbootinaction.services.impl;

import cn.wwinter.springbootinaction.model.domain.Option;
import cn.wwinter.springbootinaction.repositories.OptionRepository;
import cn.wwinter.springbootinaction.services.OptionService;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName: OptionServiceImpl
 * Package: cn.wwinter.springbootinaction.services.impl
 * Description:
 * Datetime: 2023/11/20
 * Author: zhangdd
 */
@Service
@AllArgsConstructor
public class OptionServiceImpl implements OptionService {
    private final OptionRepository optionRepository;
    private static final String OPTIONS_KEY = "'options_key'";
    private static final String OPTIONS_CACHE_NAME = "options_cache";

    @Override

    public String findOneOption(String theme) {
        return optionRepository.findOptionByOptionName(theme).getOptionValue();
    }

    @Cacheable(value = OPTIONS_CACHE_NAME, key = OPTIONS_KEY)
    @Override
    public Map<String, String> findAllOptions() {
        Map<String, String> options = new HashMap<>();
        List<Option> optionList = optionRepository.findAll();
        optionList.forEach(s -> options.put(s.getOptionName(), s.getOptionValue()));
        return options;
    }

}
