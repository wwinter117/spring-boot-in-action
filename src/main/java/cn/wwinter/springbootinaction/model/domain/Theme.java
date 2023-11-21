package cn.wwinter.springbootinaction.model.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * ClassName: Theme
 * Package: cn.wwinter.springbootinaction.domain.domain
 * Description:
 * Datetime: 2023/11/21
 * Author: zhangdd
 */
@Data
public class Theme implements Serializable {
    private Integer themeId;
    private String themeName;
    private String themeScreenShot;
}
