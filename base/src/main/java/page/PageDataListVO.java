package page;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dongjiaming
 * @Description
 * @title: PageDataListVO
 * @projectName study
 * @date 2022/4/3020:33
 */
public class PageDataListVO<T> implements Serializable {

    private final List<T> data;

    private final Integer items;

    public PageDataListVO(List<T> list, int items) {
        this.data = (CollUtil.isEmpty(list)) ? new ArrayList<T>() : list;
        this.items = items;
    }

    public PageDataListVO(T data) {
        if (ObjectUtil.isNull(data)) {
            this.data = new ArrayList<T>();
            this.items = 0;
        } else {
            ArrayList arrayList = new ArrayList<T>();
            arrayList.add(data);
            this.data = arrayList;
            this.items = 1;
        }
    }

    public List<T> getData() {
        return data;
    }

    public Integer getItems() {
        return items;
    }
}
