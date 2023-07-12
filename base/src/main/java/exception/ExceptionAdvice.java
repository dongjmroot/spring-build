package exception;


import org.omg.CORBA.SystemException;

import result.BaseResponse;

@ControllerAdvice
public class ExceptionAdvice {

    @ResponseBody
    @ExceptionHandler(SystemException.class)
    public BaseResponse<Object> handleException(Exception e) {
        logger.error("系统异常信息：", e);
        BaseResponse<Object> result = new BaseResponse<>();
        if (e instanceof BaseException) {
            e = (BaseException) e;
            result.setCode(((BaseException) e).getCode());
        }
        result.setMsg(e.getMessage());
        return result;
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public BaseResponse<Object> handleException(RuntimeException e) {
        BaseResponse<Object> result = new BaseResponse<>();
        result.setCode("500");
        result.setMsg(e.getMessage());
        return result;
    }

    @ExceptionHandler(BaseException.class)
    @ResponseBody
    public BaseResponse<Object> doBusinessException(Exception e) {
        BaseResponse<Object> result = new BaseResponse<>();
        result.setCode("500");
        result.setMsg(e.getMessage());
        return result;
    }

}
