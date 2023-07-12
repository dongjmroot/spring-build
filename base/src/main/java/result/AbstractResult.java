package result;


import menu.CanaryEnum;

/**
 * @author dongjiaming
 * @Description
 * @title: AbstractResult
 * @projectName study
 * @date 2022/4/3020:49
 */
public class AbstractResult<T> implements Result<T> {

    protected ReMessage error;
    protected T data;

    public AbstractResult(ReMessage error, T dataT) {
        this.error = error;
        this.data = dataT;
    }

    public AbstractResult(String code, String msg, T dataT) {
        this.error = new ReMessage(code, msg);
        this.data = dataT;
    }

    public AbstractResult(CanaryEnum canaryEnum) {
        ReMessage error = new ReMessage();
        error.setReturnCode(canaryEnum.getCode());
        error.setReturnMessage(canaryEnum.getDescription());
        error.setReturnUserMessage(canaryEnum.getDescription());
        error.setSuccess(false);
        this.error = error;
        this.data = null;
    }

    @Override
    public ReMessage getError() {
        return this.error;
    }

    @Override
    public void setError(ReMessage error) {
        this.error = error;
    }

    @Override
    public T getData() {
        return this.data;
    }

    @Override
    public void setData(T dataT) {
        this.data = dataT;
    }
}
