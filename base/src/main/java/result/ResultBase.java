package result;



import exception.CommonException;
import menu.CaryEnum;

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
    private static final long serialVersionUID = 72268084939619307L;

    /**
     * 是否业务处理成功，默认为失败
     */
    private boolean success = false;

    private String code = null;

    private String errorMsg = "未知异常";


    public void setBaseException(CommonException e) {
        this.success = false;
        CaryEnum caryEnum = e.getCanaryEnum();
        if (caryEnum == null) {
            setCode(e.getCode());
            setErrorMsg(e.getMsg());
        } else {
            setCanaryEnum(caryEnum);
        }
    }

    public void setCanaryEnum(CaryEnum caryEnum) {
        this.success = false;
        setCode(caryEnum.getCode());
        setErrorMsg(caryEnum.getDescription());
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

