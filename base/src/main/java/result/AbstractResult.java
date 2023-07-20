package result;


import lombok.Data;
import menu.CommonEnum;

/**
 * @author dongjiaming
 * @Description
 * @title: AbstractResult
 * @projectName study
 * @date 2022/4/3020:49
 */
@Data
public class AbstractResult<T> implements Result<T> {

    protected ResultMessage error;
    protected T data;

    public AbstractResult(ResultMessage message, T dataT) {
        this.error = message;
        this.data = dataT;
    }

    public AbstractResult(String code, String msg, T dataT) {
        this.error = new ResultMessage(code, msg);
        this.data = dataT;
    }

    public AbstractResult(CommonEnum commonEnum) {
        ResultMessage error = new ResultMessage();
        error.setReturnCode(commonEnum.getCode());
        error.setReturnMessage(commonEnum.getDescription());
        error.setReturnUserMessage(commonEnum.getDescription());
        error.setSuccess(false);
        this.error = error;
        this.data = null;
    }

}
