package cn.wwinter.springbootinaction.model.domain;

import lombok.Data;

import jakarta.persistence.*;
import java.io.Serializable;

/**
 * @author : RYAN0UP
 * @date : 2017/11/14
 * @version : 1.0
 * description : 用户详细信息实体类
 */
@Data
@Entity
@Table(name = "t_usermeta")
public class UserMeta implements Serializable{
    @Id
    @GeneratedValue
    private Integer userMetaId;
    private Integer userId;
    private String userMetaKey;
    @Lob
    private String userMetaValue;
}
