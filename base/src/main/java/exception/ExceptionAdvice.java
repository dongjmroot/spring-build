package exception;


import org.omg.CORBA.SystemException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import result.CommonResponse;

@ControllerAdvice
public class ExceptionAdvice {

    @ResponseBody
    @ExceptionHandler(SystemException.class)
    public CommonResponse<Object> handleException(Exception e) {
        CommonResponse<Object> result = new CommonResponse<>();
        if (e instanceof CommonException) {
            e = (CommonException) e;
            result.setCode(((CommonException) e).getCode());
        }
        result.setMsg(e.getMessage());
        return result;
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public CommonResponse<Object> handleException(RuntimeException e) {
        CommonResponse<Object> result = new CommonResponse<>();
        result.setCode("500");
        result.setMsg(e.getMessage());
        return result;
    }

    @ExceptionHandler(CommonException.class)
    @ResponseBody
    public CommonResponse<Object> doBusinessException(Exception e) {
        CommonResponse<Object> result = new CommonResponse<>();
        result.setCode("500");
        result.setMsg(e.getMessage());
        return result;
    }

}
