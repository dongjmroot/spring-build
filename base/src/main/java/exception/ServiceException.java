package exception;


import menu.CaryEnum;
import org.apache.commons.lang3.StringUtils;

/**
 * @author dongjiaming
 * @Description
 * @title: ServiceException
 * @projectName study
 * @date 2022/4/3019:56
 */
public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = -61319819050460519L;

    protected String msg;
    protected String code;
    protected CaryEnum caryEnum;

    public ServiceException() {
        super();
    }

    /**
     * 业务异常,只抛出message,不会调用堆栈信息
     */
    public ServiceException(String message) {
        super(message);
        this.msg = message;
        this.caryEnum = null;
    }

    public ServiceException(String code, String message) {
        super(message);
        this.msg = message;
        this.code = code;
        this.caryEnum = null;
    }

    public ServiceException(CaryEnum caryEnum) {
        super(caryEnum.getDescription());
        this.msg = caryEnum.getDescription();
        this.code = caryEnum.getCode();
        this.caryEnum = caryEnum;
    }


    public String getCode() {
        if (StringUtils.isBlank(code)) {
            return "-1";
        }
        return code;
    }

    public CaryEnum getCanaryEnum() {
        return caryEnum;
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
