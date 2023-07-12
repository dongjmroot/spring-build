package page;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author dongjiaming
 * @Description
 * @title: DataListVO
 * @projectName study
 * @date 2022/4/3020:31
 */
public class DataListVO<T> implements Serializable {

    private final List<T> data;

    public DataListVO(List<T> list) {
        this.data = (CollUtil.isEmpty(list)) ? new ArrayList<T>() : list;
    }

    public DataListVO(Set<T> list) {
        this.data = (CollUtil.isEmpty(list)) ? new ArrayList<T>() : new ArrayList<T>(list);
    }

    public DataListVO(T data) {
        if (ObjectUtil.isNull(data)) {
            this.data = new ArrayList<T>();
        } else {
            ArrayList arrayList = new ArrayList<T>();
            arrayList.add(data);
            this.data = arrayList;
        }
    }

    public List<T> getData() {
        return data;
    }
}
