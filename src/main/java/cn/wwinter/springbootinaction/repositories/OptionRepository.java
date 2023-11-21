package cn.wwinter.springbootinaction.repositories;

import cn.wwinter.springbootinaction.model.domain.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * ClassName: OptionRepository
 * Package: cn.wwinter.springbootinaction.repositories
 * Description:
 * Datetime: 2023/11/20
 * Author: zhangdd
 */
@Repository
public interface OptionRepository extends JpaRepository<Option, Integer> {
    /**
     * 根据key查询单个option
     * @param key key
     * @return String
     */
    Option findOptionByOptionName(String key);

}
