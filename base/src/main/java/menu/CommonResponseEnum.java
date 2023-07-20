package menu;

import lombok.Data;

/**
 * @author dongjiaming
 * @Description
 * @title: CommonResponseEnum
 * @projectName study
 * @date 2022/4/3020:28
 */
public enum CommonResponseEnum {

    Success("200", "处理成功"),

    FAIL_PARAM_NULL("401", "参数缺失"),

    FAIL_PARAM_Error("402", "参数错误"),

    Time_Out("408", "服务端请求超时"),

    Error("503", "系统异常,请稍后重试"),

    ;


    String code;

    String description;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    CommonResponseEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }
}
