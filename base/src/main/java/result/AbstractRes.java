package result;


import menu.CaryEnum;

/**
 * @author dongjiaming
 * @Description
 * @title: AbstractRes
 * @projectName study
 * @date 2022/4/3020:49
 */
public class AbstractRes<T> implements Res<T> {

    protected ResMessage error;
    protected T data;

    public AbstractRes(ResMessage error, T dataT) {
        this.error = error;
        this.data = dataT;
    }

    public AbstractRes(String code, String msg, T dataT) {
        this.error = new ResMessage(code, msg);
        this.data = dataT;
    }

    public AbstractRes(CaryEnum caryEnum) {
        ResMessage error = new ResMessage();
        error.setReturnCode(caryEnum.getCode());
        error.setReturnMessage(caryEnum.getDescription());
        error.setReturnUserMessage(caryEnum.getDescription());
        error.setSuccess(false);
        this.error = error;
        this.data = null;
    }

    @Override
    public ResMessage getError() {
        return this.error;
    }

    @Override
    public void setError(ResMessage error) {
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
