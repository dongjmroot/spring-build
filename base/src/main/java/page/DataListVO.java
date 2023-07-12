package page;

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
public class DataListVO<E> implements Serializable {

    private final List<E> data;

    public DataListVO(List<E> list) {
        this.data = (list == null) ? new ArrayList<E>() : list;
    }

    public DataListVO(Set<E> list) {
        this.data = (list == null) ? new ArrayList<E>() : new ArrayList<E>(list);
    }

    public DataListVO(E data) {
        if (data == null) {
            this.data = new ArrayList<E>();
        } else {
            ArrayList arrayList = new ArrayList<E>();
            arrayList.add(data);
            this.data = arrayList;
        }
    }

    public List<E> getData() {
        return data;
    }
}
