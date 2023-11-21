package cn.wwinter.springbootinaction.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : RYAN0UP
 * @version : 1.0
 * description :
 * @date : 2018/1/12
 */
@Data
@Entity
@Table(name = "t_tag")
public class Tag implements Serializable{
    @Id
    @GeneratedValue
    private Integer tagId;
    private String tagName;
    private String tagUrl;

    @ManyToMany(mappedBy = "tags")
    @JsonIgnore
    private List<Post> posts = new ArrayList<>();
}
