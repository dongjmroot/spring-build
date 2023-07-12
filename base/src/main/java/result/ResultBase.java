package result;



import exception.BaseException;
import menu.CanaryEnum;

import java.io.Serializable;

/**
 * @author dongjiaming
 * @Description
 * @title: ResultBase
 * @projectName study
 * @date 2022/4/3020:35
 */
public class ResultBase implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 7226805584939619307L;

    /**
     * 是否业务处理成功，默认为失败
     */
    private boolean success = false;

    private String code = null;

    private String errorMsg = "未知异常";


    public void setBaseException(BaseException e) {
        this.success = false;
        CanaryEnum canaryEnum = e.getCanaryEnum();
        if (canaryEnum == null) {
            setCode(e.getCode());
            setErrorMsg(e.getMsg());
        } else {
            setCanaryEnum(canaryEnum);
        }
    }

    public void setCanaryEnum(CanaryEnum canaryEnum) {
        this.success = false;
        setCode(canaryEnum.getCode());
        setErrorMsg(canaryEnum.getDescription());
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        if (success) {
            this.errorMsg = "";
        }
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }


}

