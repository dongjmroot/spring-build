package exception;


import menu.CanaryEnum;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * @author dongjiaming
 * @Description
 * @title: BaseException
 * @projectName study
 * @date 2022/4/3019:54
 */
public class BaseException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 2289672303720789154L;
    protected String msg;
    protected String code;
    protected CanaryEnum canaryEnum;

    public BaseException() {
        super();
    }

    /**
     * 业务异常,只抛出message,不会调用堆栈信息
     */
    public BaseException(String message) {
        super(message);
        this.msg = message;
        this.canaryEnum = null;
    }

    public BaseException(String code, String message) {
        super(message);
        this.msg = message;
        this.code = code;
        this.canaryEnum = null;
    }

    public BaseException(CanaryEnum canaryEnum) {
        super(canaryEnum.getDescription());
        this.msg = canaryEnum.getDescription();
        this.code = canaryEnum.getCode();
        this.canaryEnum = canaryEnum;
    }


    public BaseException(Exception e) {
        super(e);
    }

    public String getCode() {
        if (StringUtils.isBlank(code)) {
            //return "-1";
            return "500";
        }
        return code;
    }

    public CanaryEnum getCanaryEnum() {
        return canaryEnum;
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
        return "BaseException{" +
                "msg='" + msg + '\'' +
                ", code='" + code + '\'' +
                "} " + super.toString();
    }
}
