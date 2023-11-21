package cn.wwinter.springbootinaction.repositories;

import cn.wwinter.springbootinaction.model.domain.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * ClassName: AttachmentRepository
 * Package: cn.wwinter.springbootinaction.repositories
 * Description:
 * Datetime: 2023/11/21
 * Author: zhangdd
 */
@Repository
public interface AttachmentRepository extends JpaRepository<Attachment, Integer> {

}
