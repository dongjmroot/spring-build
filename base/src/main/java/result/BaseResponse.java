package result;


import exception.BaseException;
import io.swagger.annotations.ApiModelProperty;
import menu.BaseResponseEnum;
import utils.IDUtils;

import java.io.Serializable;

/**
 * @author dongjiaming
 * @Description
 * @title: BaseResponse
 * @projectName study
 * @date 2022/4/3020:27
 */
public class BaseResponse<T> implements Serializable {

    private static final long serialVersionUID = 5224233810467777892L;
    @ApiModelProperty(value = "请求id")
    private String requestId;
    @ApiModelProperty(value = "是否成功")
    private boolean success;
    @ApiModelProperty(value = "错误信息")
    private String message;
    @ApiModelProperty(value = "错误码")
    private String code;

    @ApiModelProperty(value = "返回对象")
    private T result;

    public BaseResponse() {
    }

    public BaseResponse(String retCode, String retMsg) {
        this.result = null;
        this.code = retCode;
        this.requestId = IDUtils.getTraceID();
        if (BaseResponseEnum.Success.getCode().equals(retCode)) {
            this.success = true;
        } else {
            this.message = retMsg;
        }
    }

    public BaseResponse(BaseResponseEnum baseResponseEnum) {
        this.result = null;
        this.code = baseResponseEnum.getCode();
        if (baseResponseEnum.getCode().equals(BaseResponseEnum.Success.getCode())) {
            this.success = true;
        } else {
            this.message = baseResponseEnum.getDescription();
        }
    }

    public BaseResponse(BaseResponseEnum baseResponseEnum, T result) {
        this.result = result;
        this.code = baseResponseEnum.getCode();
        this.requestId = IDUtils.getTraceID();
        if (baseResponseEnum.getCode().equals(BaseResponseEnum.Success.getCode())) {
            this.success = true;
        } else {
            this.message = baseResponseEnum.getDescription();
        }
    }


    public BaseResponse(String retMsg) {
        this.result = null;
        this.code = "-1";
        this.message = retMsg;
        this.success = false;
    }

    public BaseResponse(BaseException ex) {
        this.result = null;
        this.code = "-1";
        this.message = ex.getMessage();
        this.success = false;

    }

    public static <T> BaseResponse<T> success() {
        return new BaseResponse(BaseResponseEnum.Success, null);
    }

    public static <T> BaseResponse<T> success(T data) {
        return new BaseResponse(BaseResponseEnum.Success, data);
    }

    public static <T> BaseResponse<T> success(String msg, T data) {
        BaseResponse baseResponse = new BaseResponse(BaseResponseEnum.Success, data);
        baseResponse.setMsg(msg);
        return baseResponse;
    }

    public static <T> BaseResponse<T> success(String msg) {
        BaseResponse baseResponse = new BaseResponse(BaseResponseEnum.Success);
        baseResponse.setMsg(msg);
        return baseResponse;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
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

    public void setCode(String code) {
        this.code = code;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "requestId='" + requestId + '\'' +
                ", success=" + success +
                ", msg='" + message + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
