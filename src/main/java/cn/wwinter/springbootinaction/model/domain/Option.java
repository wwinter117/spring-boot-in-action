package cn.wwinter.springbootinaction.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;

/**
 * ClassName: Option
 * Package: cn.wwinter.springbootinaction.domain.entities
 * Description:
 * Datetime: 2023/11/20
 * Author: zhangdd
 */
@Data
@Entity
@Table(name = "t_options")
public class Option implements Serializable {
    @Id
    private String optionName;
    @Lob
    private String optionValue;
}
