package cn.wwinter.springbootinaction.model.domain;

import lombok.Data;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author : RYAN0UP
 * @date : 2017/11/14
 * @version : 1.0
 * description : 文章实体类
 */
@Data
@Entity
@Table(name = "t_post")
public class Post implements Serializable{
    /**
     * 文章编号
     */
    @Id
    @GeneratedValue
    private Integer postId;

    /**
     * 发表用户 多对一
     */
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    /**
     * 文章标题
     */
    private String postTitle;

    /**
     * 文章内容 Markdown格式
     */
    @Lob
    private String postContentMd;

    /**
     * 文章内容 html格式
     */
    @Lob
    private String postContent;

    /**
     * 文章路径
     */
    @Column(unique = true)
    private String postUrl;

    /**
     * 文章摘要
     */
    private String postSummary;

    /**
     * 文章所属分类
     */
    @ManyToMany(cascade = {CascadeType.PERSIST},fetch = FetchType.LAZY)
    @JoinTable(name = "halo_posts_categories",
            joinColumns = {@JoinColumn(name = "post_id",nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "cate_id",nullable = false)})
    private List<Category> categories = new ArrayList<>();

    /**
     * 文章所属标签
     */
    @ManyToMany(cascade = {CascadeType.PERSIST},fetch = FetchType.LAZY)
    @JoinTable(name = "halo_posts_tags",
            joinColumns = {@JoinColumn(name = "post_id",nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "tag_id",nullable = false)})
    private List<Tag> tags = new ArrayList<>();

    /**
     * 发表日期
     */
    private Date postDate;

    /**
     * 0 已发布
     * 1 草稿
     * 2 回收站
     */
    private Integer postStatus = 0;
}
