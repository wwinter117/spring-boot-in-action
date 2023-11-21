package cn.wwinter.springbootinaction.services;

import cn.wwinter.springbootinaction.model.domain.Logs;

import java.util.List;

/**
 * ClassName: LogServiceImpl
 * Package: cn.wwinter.springbootinaction.services
 * Description:
 * Datetime: 2023/11/21
 * Author: zhangdd
 */
public interface LogService {
    List<Logs> findLogsLatest();
}
