package menu;

/**
 * @author dongjiaming
 * @Description
 * @title: ErrorCodeSystemEnum
 * @projectName study
 * @date 2022/4/3019:49
 */
public enum ErrorCodeSystemEnum implements CanaryEnum {

    LoginPassError("LoginPassError", 200, "LoginPassError", "用户名/密码错误！"),
    RequestIllegal("RequestIllegal", 200, "RequestIllegal", "请求非法！"),

    AuthorizationError("AuthorizationError", 403, "AuthorizationError", "未登陆！"),

    NoAuthorization("NoAuthorization", 401, "NoAuthorization", "无权限！"),

    DateArgument("DateArgumentError", 400, "DateArgumentError", "日期格式错误！"),
    TimeArgument("TimeArgumentError", 400, "TimeArgumentError", "时间格式错误！"),


    SystemException("iot.system.SystemException", "系统异常，请稍后重试！"),

    SignException("iot.system.SignException", "签名算法错误"),

    SignCheckError("iot.system.SignCheckError", 6600, "签名校验失败", "签名校验失败"),
    SignError("iot.system.SignError", 6600, "签名失败", "签名失败"),

    SystemExceptionTime("iot.system.SystemExceptionTime", "请稍后重试！"),
    FAIL_PARAM_NULL("iot.system.FAIL_PARAM_NULL", "必要参数缺失！"),
    FAIL_PARAM_NULL_SIGN("iot.system.FAIL_PARAM_NULL_SIGN", "必要参数缺失！"),
    FAIL_PARAM_ERROR("iot.system.FAIL_PARAM_ERROR", "参数错误！"),

    AuthActionPermissionDeny("iot.common.AuthActionPermissionDeny", "鉴权失败！"),

    InvalidPageParams("iot.common.InvalidPageParams", "分页大小或者分页页号不合法。"),
//    QueryDeviceError("iot.common.QueryDeviceError", "查询设备失败。"),
//    QueryProductError("iot.common.QueryProductError", "查询产品失败。"),


    /*rrpc和广播*/
    BroadcastNeedParams("iot.broadcast.BroadcastNeedParams", "缺少必要执行广播参数。"),
    BroadcastError("iot.broadcast.BroadcastError", "执行广播任务出现系统错误。"),
    BroadcastTopicValid("iot.broadcast.BroadcastTopicValid", "执行广播Topic不合规。"),
    RrpcNeedParams("iot.rrpc.RrpcNeedParams", "缺少必要执行rrpc参数。"),
    RrpcTimeoutValid("iot.rrpc.RrpcTimeoutValid", "rrpc执行参数timeout不合规。"),

    ;


    /**
     * 枚举编码
     */
    private final String code;

    private final Integer codeInteger;

    private final String codeMessage;

    /**
     * 枚举描述
     */
    private final String description;


    ErrorCodeSystemEnum(String code, String description) {
        this.code = code;
        this.description = description;
        this.codeInteger = null;
        this.codeMessage = null;
    }

    ErrorCodeSystemEnum(String code, Integer codeInteger, String codeMessage, String description) {
        this.code = code;
        this.codeInteger = codeInteger;
        this.codeMessage = codeMessage;
        this.description = description;
    }

    public static ErrorCodeSystemEnum getByCode(String code) {
        for (ErrorCodeSystemEnum scenario : values()) {
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
    public Integer getCodeInteger() {
        return codeInteger;
    }

    @Override
    public String getCodeMessage() {
        if (codeMessage == null) {
            return description;
        }
        return codeMessage;
    }
}
