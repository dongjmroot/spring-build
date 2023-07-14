package exception;


import menu.CommonEnum;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * @author dongjiaming
 * @Description
 * @title: CommonException
 * @projectName study
 * @date 2022/4/3019:54
 */
public class CommonException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 2289672303720789154L;
    protected String msg;
    protected String code;
    protected CommonEnum commonEnum;

    public CommonException() {
        super();
    }

    /**
     * 业务异常,只抛出message,不会调用堆栈信息
     */
    public CommonException(String message) {
        super(message);
        this.msg = message;
        this.commonEnum = null;
    }

    public CommonException(String code, String message) {
        super(message);
        this.msg = message;
        this.code = code;
        this.commonEnum = null;
    }

    public CommonException(CommonEnum commonEnum) {
        super(commonEnum.getDescription());
        this.msg = commonEnum.getDescription();
        this.code = commonEnum.getCode();
        this.commonEnum = commonEnum;
    }


    public CommonException(Exception e) {
        super(e);
    }

    public String getCode() {
        if (StringUtils.isBlank(code)) {
            return "500";
        }
        return code;
    }

    public CommonEnum getCanaryEnum() {
        return commonEnum;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }

    @Override
    public String toString() {
        return "CommonException{" +
                "msg='" + msg + '\'' +
                ", code='" + code + '\'' +
                "} " + super.toString();
    }
}
