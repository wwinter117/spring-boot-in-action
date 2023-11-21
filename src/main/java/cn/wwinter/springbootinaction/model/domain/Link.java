package cn.wwinter.springbootinaction.model.domain;

import lombok.Data;
import jakarta.persistence.*;
import java.io.Serializable;

/**
 * @author : RYAN0UP
 * @date : 2017/11/14
 * @version : 1.0
 * description : 友情链接的实体类
 */
@Data
@Entity
@Table(name = "t_link")
public class Link implements Serializable{
    @Id
    @GeneratedValue
    private Integer linkId;
    private String linkName;
    private String linkUrl;
    private String linkPic;
    private String linkDesc;
}
