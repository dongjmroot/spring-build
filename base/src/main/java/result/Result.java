package result;

import java.io.Serializable;

/**
 * @author dongjiaming
 * @Description
 * @title: Result
 * @projectName study
 * @date 2022/4/3019:58
 */
public interface Result<T> extends Serializable {

    void setData(T data);
    T getData();
    void setError(ResultMessage msg);
    ResultMessage getError();
}

