package cn.wwinter.springbootinaction.services;

import cn.wwinter.springbootinaction.model.domain.Attachment;

import java.util.List;

/**
 * ClassName: AttachmentService
 * Package: cn.wwinter.springbootinaction.services
 * Description:
 * Datetime: 2023/11/21
 * Author: zhangdd
 */
public interface AttachmentService {
    List<Attachment> findAllAttachments();
}
