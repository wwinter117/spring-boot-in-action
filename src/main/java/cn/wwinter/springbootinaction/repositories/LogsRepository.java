package cn.wwinter.springbootinaction.repositories;

import cn.wwinter.springbootinaction.model.domain.Logs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ClassName: LogsRepository
 * Package: cn.wwinter.springbootinaction.repositories
 * Description:
 * Datetime: 2023/11/21
 * Author: zhangdd
 */
@Repository
public interface LogsRepository extends JpaRepository<Logs, Long> {
    @Query(value = "SELECT * FROM t_logs ORDER BY log_id DESC LIMIT 5",nativeQuery = true)
    List<Logs> findTopFive();
}
