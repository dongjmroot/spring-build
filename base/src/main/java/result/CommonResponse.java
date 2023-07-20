package result;


import exception.CommonException;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import menu.CommonResponseEnum;
import utils.IDUtils;

import java.io.Serializable;

/**
 * @author dongjiaming
 * @Description
 * @title: CommonResponse
 * @projectName study
 * @date 2022/4/3020:27
 */

@Data
public class CommonResponse<T> implements Serializable {

    private static final long serialVersionUID = 5224233810467777892L;
    @ApiModelProperty(value = "请求id")
    private String requestId;
    @ApiModelProperty(value = "是否成功")
    private boolean isSuccess;
    @ApiModelProperty(value = "错误信息")
    private String message;
    @ApiModelProperty(value = "错误码")
    private String code;

    @ApiModelProperty(value = "返回对象")
    private T result;

    public CommonResponse() {
    }

    public CommonResponse(String retCode, String retMsg) {
        this.result = null;
        this.code = retCode;
        this.requestId = IDUtils.getTraceID();
        if (CommonResponseEnum.Success.getCode().equals(retCode)) {
            this.isSuccess = true;
        } else {
            this.message = retMsg;
        }
    }

    public CommonResponse(CommonResponseEnum commonResponseEnum) {
        this.result = null;
        this.code = commonResponseEnum.getCode();
        if (commonResponseEnum.getCode().equals(CommonResponseEnum.Success.getCode())) {
            this.isSuccess = true;
        } else {
            this.message = commonResponseEnum.getDescription();
        }
    }

    public CommonResponse(CommonResponseEnum commonResponseEnum, T result) {
        this.result = result;
        this.code = commonResponseEnum.getCode();
        this.requestId = IDUtils.getTraceID();
        if (commonResponseEnum.getCode().equals(CommonResponseEnum.Success.getCode())) {
            this.isSuccess = true;
        } else {
            this.message = commonResponseEnum.getDescription();
        }
    }


    public CommonResponse(String retMsg) {
        this.result = null;
        this.code = "-1";
        this.message = retMsg;
        this.isSuccess = false;
    }

    public CommonResponse(CommonException ex) {
        this.result = null;
        this.code = "-1";
        this.message = ex.getMessage();
        this.isSuccess = false;

    }

    public static <T> CommonResponse<T> success() {
        return new CommonResponse(CommonResponseEnum.Success, null);
    }

    public static <T> CommonResponse<T> success(T data) {
        return new CommonResponse(CommonResponseEnum.Success, data);
    }

    public static <T> CommonResponse<T> success(String msg, T data) {
        CommonResponse commonResponse = new CommonResponse(CommonResponseEnum.Success, data);
        commonResponse.setMsg(msg);
        return commonResponse;
    }

    public static <T> CommonResponse<T> success(String msg) {
        CommonResponse commonResponse = new CommonResponse(CommonResponseEnum.Success);
        commonResponse.setMsg(msg);
        return commonResponse;
    }

    public String getMsg() {
        return message;
    }

    public void setMsg(String msg) {
        this.message = msg;
    }

    public String getCode() {
        return code;
    }


    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "CommonResponse{" +
                "requestId='" + requestId + '\'' +
                ", success=" + isSuccess +
                ", msg='" + message + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
