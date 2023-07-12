package result;

import com.study.base.exception.BaseException;
import com.study.constant.sys.CanaryEnum;

import java.io.Serializable;

/**
 * @author dongjiaming
 * @Description
 * @title: ReMessage
 * @projectName study
 * @date 2022/4/3019:57
 */
public class ReMessage  implements Serializable {

    private String returnCode;
    private boolean success;
    private String returnMessage;
    private String returnUserMessage;

    public String getReturnCode() {
        return this.returnCode;
    }

    public ReMessage(String returnCode, String returnMessage) {
        this.returnCode = returnCode;
        this.returnMessage = returnMessage;
        this.returnUserMessage = returnMessage;
        if (returnCode.equals("0")) {
            this.success = true;
        }
    }

    public ReMessage(CanaryEnum canaryEnum) {
        this.returnCode = canaryEnum.getCode();
        this.returnMessage = canaryEnum.getDescription();
        this.returnUserMessage = canaryEnum.getDescription();
    }

    public ReMessage(BaseException ex) {
        CanaryEnum canaryEnum = ex.getCanaryEnum();
        if (canaryEnum != null) {
//            new ReMessage(canaryEnum);
            this.returnCode = canaryEnum.getCode();
            this.returnMessage = canaryEnum.getDescription();
            this.returnUserMessage = canaryEnum.getDescription();
        } else {
            this.returnCode = ex.getCode();
            this.returnMessage = ex.getMsg();
            this.returnUserMessage = ex.getMsg();
        }
    }


    public void setReturnCode(String returnCode) {

        this.returnCode = returnCode;
        if (returnCode.equals("0")) {
            this.success = true;
        }
    }

    public String getReturnMessage() {
        return this.returnMessage;
    }

    public void setReturnMessage(String returnMessage) {
        this.returnMessage = returnMessage;
    }

    public String getReturnUserMessage() {
        return this.returnUserMessage;
    }

    public void setReturnUserMessage(String returnUserMessage) {
        this.returnUserMessage = returnUserMessage;
    }

    public ReMessage(String returnCode, String returnMessage, String returnUserMessage) {
        this.returnCode = returnCode;
        this.returnMessage = returnMessage;
        this.returnUserMessage = returnUserMessage;
        if (returnCode.equals("0")) {
            this.success = true;
        }
    }


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public ReMessage() {
    }

    @Override
    public String toString() {
        return "ReMessage{" +
                "returnCode='" + returnCode + '\'' +
                ", returnMessage='" + returnMessage + '\'' +
                ", returnUserMessage='" + returnUserMessage + '\'' +
                '}';
    }
}

