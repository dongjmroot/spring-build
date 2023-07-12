package result;


import exception.CommonException;
import menu.CaryEnum;

import java.io.Serializable;

/**
 * @author dongjiaming
 * @Description
 * @title: ResMessage
 * @projectName study
 * @date 2022/4/3019:57
 */
public class ResMessage implements Serializable {

    private String returnCode;
    private boolean success;
    private String returnMessage;
    private String returnUserMessage;

    public String getReturnCode() {
        return this.returnCode;
    }

    public ResMessage(String returnCode, String returnMessage) {
        this.returnCode = returnCode;
        this.returnMessage = returnMessage;
        this.returnUserMessage = returnMessage;
        if ("0".equals(returnCode)) {
            this.success = true;
        }
    }

    public ResMessage(CaryEnum caryEnum) {
        this.returnCode = caryEnum.getCode();
        this.returnMessage = caryEnum.getDescription();
        this.returnUserMessage = caryEnum.getDescription();
    }

    public ResMessage(CommonException ex) {
        CaryEnum caryEnum = ex.getCanaryEnum();
        if (caryEnum != null) {
//            new ResMessage(caryEnum);
            this.returnCode = caryEnum.getCode();
            this.returnMessage = caryEnum.getDescription();
            this.returnUserMessage = caryEnum.getDescription();
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

    public ResMessage(String returnCode, String returnMessage, String returnUserMessage) {
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

    public ResMessage() {
    }

    @Override
    public String toString() {
        return "ResMessage{" +
                "returnCode='" + returnCode + '\'' +
                ", returnMessage='" + returnMessage + '\'' +
                ", returnUserMessage='" + returnUserMessage + '\'' +
                '}';
    }
}

