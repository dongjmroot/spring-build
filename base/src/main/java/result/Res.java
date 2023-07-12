package result;

import java.io.Serializable;

/**
 * @author dongjiaming
 * @Description
 * @title: Res
 * @projectName study
 * @date 2022/4/3019:58
 */
public interface Res<T> extends Serializable {
    T getData();

    void setData(T var1);

    ResMessage getError();

    void setError(ResMessage var1);
}

