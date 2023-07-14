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
    T getData();

    void setData(T var1);

    ResultMessage getError();

    void setError(ResultMessage var1);
}

