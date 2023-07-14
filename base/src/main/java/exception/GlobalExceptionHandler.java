package exception;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import result.CommonResponse;

import java.util.List;

/**
 * @author
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {


    /**
     * 校验错误拦截处理
     *
     * @param exception 错误信息集合
     * @return CommonResponse 错误响应，当HTTP响应状态码不为200时，使用该响应返回
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    private CommonResponse validateRequestException(MethodArgumentNotValidException exception) {
        BindingResult bindingResult = exception.getBindingResult();
        StringBuilder errorMsg = new StringBuilder();
        if (bindingResult.hasErrors()) {
            List<ObjectError> errors = bindingResult.getAllErrors();
            for (ObjectError objectError : errors) {
                FieldError fieldError = (FieldError) objectError;
                if (log.isDebugEnabled()) {
                    log.error("Data check failure : object: {},field: {},errorMessage: {}",
                            fieldError.getObjectName(), fieldError.getField(), fieldError.getDefaultMessage());
                }
                errorMsg.append(objectError.getDefaultMessage());
                errorMsg.append(",");
            }
            errorMsg = new StringBuilder(errorMsg.substring(0, errorMsg.length() - 1));
        }
        return new CommonResponse("400", errorMsg.toString());
    }

}
