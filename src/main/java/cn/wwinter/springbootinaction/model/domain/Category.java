package cn.wwinter.springbootinaction.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : RYAN0UP
 * @date : 2017/11/30
 * @version : 1.0
 * description : 分类目录实体类
 */
@Data
@Entity
@Table(name = "t_category")
public class Category implements Serializable{
    @Id
    @GeneratedValue
    private Integer cateId;
    private String cateName;
    private String cateUrl;
    private String cateDesc;

    @ManyToMany(mappedBy = "categories")
    @JsonIgnore
    private List<Post> posts = new ArrayList<>();
}
