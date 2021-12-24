/**
 * From geek45.com
 * Email to : rubixgeek795@gmail.com
 */
package com.geek45.geekresult.enums;

/**
 * @ClassName: ErrorCodeEnums
 * @Decription:
 * @Author: qian
 * qian create ErrorCodeEnums.java of 2021/12/24 10:42 下午
 */
public enum ResultCodeEnums {
    SUCCESS("成功", "200"),
    BIZ_EXCEPTION("业务异常", "405"),
    SYSTEM_ERROR("系统异常", "500"),
    NOT_FOUND("未找到指定资源", "404"),
    BAD_REQUEST("错误的请求", "400"),
    PARAM_REQUEST("参数异常", "412"),
    UNAUTHORIZED("需要登录", "401"),
    FORBIDDEN("没有权限", "403"),
    ;

    private String desc;
    private String code;

    ResultCodeEnums(String desc, String code) {
        setCode(code);
        setDesc(desc);
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
