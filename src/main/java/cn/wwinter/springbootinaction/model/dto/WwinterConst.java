package cn.wwinter.springbootinaction.model.dto;

import cn.wwinter.springbootinaction.model.domain.Attachment;
import cn.wwinter.springbootinaction.model.domain.Theme;
import cn.wwinter.springbootinaction.model.domain.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName: WwinterConst
 * Package: cn.wwinter.springbootinaction.domain.dto
 * Description:
 * Datetime: 2023/11/20
 * Author: zhangdd
 */
public class WwinterConst {

    public static Map<String, String> OPTIONS = new HashMap<>();

    public static User USER = new User();

    public static List<Attachment> ATTACHMENTS = new ArrayList<>();

    public static List<Theme> THEMES = new ArrayList<>();


}
