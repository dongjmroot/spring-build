package result;


import exception.CommonException;
import menu.CommonEnum;

import java.io.Serializable;

/**
 * @author dongjiaming
 * @Description
 * @title: ResultMessage
 * @projectName study
 * @date 2022/4/3019:57
 */
public class ResultMessage implements Serializable {

    private String returnCode;
    private boolean success;
    private String returnMessage;
    private String returnUserMessage;

    final String num = "0";

    public String getReturnCode() {
        return this.returnCode;
    }

    public ResultMessage(String returnCode, String returnMessage) {
        this.returnCode = returnCode;
        this.returnMessage = returnMessage;
        this.returnUserMessage = returnMessage;
        if (num.equals(returnCode)) {
            this.success = true;
        }
    }

    public ResultMessage(CommonEnum commonEnum) {
        this.returnCode = commonEnum.getCode();
        this.returnMessage = commonEnum.getDescription();
        this.returnUserMessage = commonEnum.getDescription();
    }

    public ResultMessage(CommonException ex) {
        CommonEnum commonEnum = ex.getCanaryEnum();
        if (commonEnum != null) {
            this.returnCode = commonEnum.getCode();
            this.returnMessage = commonEnum.getDescription();
            this.returnUserMessage = commonEnum.getDescription();
        } else {
            this.returnCode = ex.getCode();
            this.returnMessage = ex.getMsg();
            this.returnUserMessage = ex.getMsg();
        }
    }


    public void setReturnCode(String returnCode) {

        this.returnCode = returnCode;
        if (returnCode.equals(num)) {
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

    public ResultMessage(String returnCode, String returnMessage, String returnUserMessage) {
        this.returnCode = returnCode;
        this.returnMessage = returnMessage;
        this.returnUserMessage = returnUserMessage;
        if (returnCode.equals(num)) {
            this.success = true;
        }
    }


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public ResultMessage() {
    }

    @Override
    public String toString() {
        return "ResultMessage{" +
                "returnCode='" + returnCode + '\'' +
                ", returnMessage='" + returnMessage + '\'' +
                ", returnUserMessage='" + returnUserMessage + '\'' +
                '}';
    }
}

