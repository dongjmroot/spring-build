package result;



import exception.CommonException;
import lombok.Data;
import menu.CommonEnum;

import java.io.Serializable;

/**
 * @author dongjiaming
 * @Description
 * @title: BaseResult
 * @projectName study
 * @date 2022/4/3020:35
 */
@Data
public class BaseResult implements Serializable {

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


    public void setCanaryEnum(CommonEnum commonEnum) {
        this.success = false;
        setCode(commonEnum.getCode());
        setErrorMsg(commonEnum.getDescription());
    }

    public void setBaseException(CommonException e) {
        this.success = false;
        CommonEnum commonEnum = e.getCanaryEnum();
        if (commonEnum == null) {
            setCode(e.getCode());
            setErrorMsg(e.getMsg());
        } else {
            setCanaryEnum(commonEnum);
        }
    }

    public void setSuccess(boolean success) {
        if (success) {
            this.errorMsg = "";
        }
        this.success = success;
    }



}

