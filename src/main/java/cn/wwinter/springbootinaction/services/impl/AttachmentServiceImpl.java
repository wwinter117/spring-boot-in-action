package cn.wwinter.springbootinaction.services.impl;

import cn.wwinter.springbootinaction.model.domain.Attachment;
import cn.wwinter.springbootinaction.repositories.AttachmentRepository;
import cn.wwinter.springbootinaction.services.AttachmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName: AttachmentServiceImpl
 * Package: cn.wwinter.springbootinaction.services.impl
 * Description:
 * Datetime: 2023/11/21
 * Author: zhangdd
 */
@Service
@AllArgsConstructor
public class AttachmentServiceImpl implements AttachmentService {

    private final AttachmentRepository attachmentRepository;
    @Override
    public List<Attachment> findAllAttachments() {
        return attachmentRepository.findAll();
    }

}
