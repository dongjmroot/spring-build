package page;

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
public class PageDataListVO<E> implements Serializable {

    private final List<E> data;

    private final Integer items;

    public PageDataListVO(List<E> list, int items) {
        this.data = (list == null) ? new ArrayList<E>() : list;
        this.items = items;
    }

    public PageDataListVO(E data) {
        if (data == null) {
            this.data = new ArrayList<E>();
            this.items = 0;
        } else {
            ArrayList arrayList = new ArrayList<E>();
            arrayList.add(data);
            this.data = arrayList;
            this.items = 1;
        }
    }

    public List<E> getData() {
        return data;
    }

    public Integer getItems() {
        return items;
    }
}
