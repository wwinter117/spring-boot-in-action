package cn.wwinter.springbootinaction.model.domain;

import lombok.Data;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author : RYAN0UP
 * @version : 1.0
 * description :
 * @date : 2018/1/19
 */
@Data
@Entity
@Table(name = "t_logs")
public class Logs implements Serializable {

    /**
     * id
     */
    @Id
    @GeneratedValue
    private Integer logId;

    /**
     * 标题
     */
    private String logTitle;

    /**
     * 内容
     */
    private String logContent;

    /**
     * 产生日志的ip
     */
    private String logIp;

    /**
     * 产生的时间
     */
    private Date logCreated;

    public Logs() { }

    public Logs(String logTitle, String logContent, String logIp, Date logCreated) {
        this.logTitle = logTitle;
        this.logContent = logContent;
        this.logIp = logIp;
        this.logCreated = logCreated;
    }
}
