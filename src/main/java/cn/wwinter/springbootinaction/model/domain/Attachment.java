package cn.wwinter.springbootinaction.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * ClassName: Attachment
 * Package: cn.wwinter.springbootinaction.domain.domain
 * Description:
 * Datetime: 2023/11/21
 * Author: zhangdd
 */
@Data
@Entity
@Table(name = "t_attachment")
public class Attachment implements Serializable {
    @Id
    @GeneratedValue
    private Integer attachId;
    private String attachName;
    private String attachPath;
    private String attachSmallPath;
    private String attachType;
    private String attachSuffix;
    private Date attachCreated;
}