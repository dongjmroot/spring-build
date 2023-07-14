package menu;

/**
 * @author dongjiaming
 * @Description
 * @title: ErrorCodeEnum
 * @projectName study
 * @date 2022/4/3019:49
 */
public enum ErrorCodeEnum implements CommonEnum {

    LoginPassError("LoginPassError", 200, "LoginPassError", "用户名/密码错误！"),
    RequestIllegal("RequestIllegal", 200, "RequestIllegal", "请求非法！"),

    AuthorizationError("AuthorizationError", 403, "AuthorizationError", "未登陆！"),

    NoAuthorization("NoAuthorization", 401, "NoAuthorization", "无权限！"),

    DateArgument("DateArgumentError", 400, "DateArgumentError", "日期格式错误！"),
    TimeArgument("TimeArgumentError", 400, "TimeArgumentError", "时间格式错误！"),

    SystemException("iot.system.SystemException", "系统异常，请稍后重试！"),

    SystemExceptionTime("SystemExceptionTime", "请稍后重试！"),
    FAIL_PARAM_NULL("FailParamNull", "必要参数缺失！"),
    FAIL_PARAM_ERROR("FailParamError", "参数错误！"),

    AuthActionPermissionDeny("AuthActionPermissionDeny", "鉴权失败！"),

    InvalidPageParams("InvalidPageParams", "分页大小或者分页页号不合法。"),
    ;

    /**
     * 枚举编码
     */
    private final String code;

    private final Integer resultCode;

    private final String codeMessage;

    /**
     * 枚举描述
     */
    private final String description;


    ErrorCodeEnum(String code, String description) {
        this.code = code;
        this.description = description;
        this.resultCode = null;
        this.codeMessage = null;
    }

    ErrorCodeEnum(String code, Integer resultCode, String codeMessage, String description) {
        this.code = code;
        this.resultCode = resultCode;
        this.codeMessage = codeMessage;
        this.description = description;
    }

    public static ErrorCodeEnum getByCode(String code) {
        for (ErrorCodeEnum scenario : values()) {
            if (scenario.getCode().equals(code)) {
                return scenario;
            }
        }
        return null;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public Integer getResultCode() {
        return resultCode;
    }

    @Override
    public String getCodeMessage() {
        if (codeMessage == null) {
            return description;
        }
        return codeMessage;
    }
}
