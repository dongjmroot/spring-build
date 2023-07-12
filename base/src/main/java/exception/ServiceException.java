package exception;


import menu.CanaryEnum;
import org.apache.commons.lang3.StringUtils;

/**
 * @author dongjiaming
 * @Description
 * @title: ServiceException
 * @projectName study
 * @date 2022/4/3019:56
 */
public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = -6131985319050460519L;

    protected String msg;
    protected String code;
    protected CanaryEnum canaryEnum;

    public ServiceException() {
        super();
    }

    /**
     * 业务异常,只抛出message,不会调用堆栈信息
     */
    public ServiceException(String message) {
        super(message);
        this.msg = message;
        this.canaryEnum = null;
    }

    public ServiceException(String code, String message) {
        super(message);
        this.msg = message;
        this.code = code;
        this.canaryEnum = null;
    }

    public ServiceException(CanaryEnum canaryEnum) {
        super(canaryEnum.getDescription());
        this.msg = canaryEnum.getDescription();
        this.code = canaryEnum.getCode();
        this.canaryEnum = canaryEnum;
    }


    public String getCode() {
        if (StringUtils.isBlank(code)) {
            return "-1";
        }
        return code;
    }

    public CanaryEnum getCanaryEnum() {
        return canaryEnum;
    }


    public ServiceException(Exception e) {
        super(e);
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
        return this.msg;
    }
}
