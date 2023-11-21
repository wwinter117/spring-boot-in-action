package cn.wwinter.springbootinaction.services.impl;

import cn.wwinter.springbootinaction.model.domain.Logs;
import cn.wwinter.springbootinaction.repositories.LogsRepository;
import cn.wwinter.springbootinaction.services.LogService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName: LogServiceImpl
 * Package: cn.wwinter.springbootinaction.services.impl
 * Description:
 * Datetime: 2023/11/21
 * Author: zhangdd
 */
@Service
@AllArgsConstructor
public class LogServiceImpl implements LogService {
    private final LogsRepository logsRepository;
    @Override
    public List<Logs> findLogsLatest() {
        return logsRepository.findTopFive();
    }
}
