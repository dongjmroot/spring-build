package page;

import java.io.Serializable;

/**
 * @author dongjiaming
 * @Description
 * @title: Paginator
 * @projectName study
 * @date 2022/4/3020:41
 */
public class Paginator implements Serializable, Cloneable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -8812244055657485069L;

    //    /**
//     * 每页默认的项数(10)。
//     */
    public static final int DEFAULT_ITEMS_PER_PAGE = 20;

    /**
     * 总项数
     */
    private int items;

    /**
     * 当前页号
     */
    private final Integer page;

    /**
     * 总页数
     */
    private final Integer pageCount;

    /**
     * 每页显示的数
     */
    private final Integer pageSize;

    public Paginator(int pageSize, int items, int page) {
        this.items = Math.max(items, 0);
        this.pageSize = (pageSize > 0) ? pageSize : DEFAULT_ITEMS_PER_PAGE;
        this.pageCount = (int) Math.ceil((double) items / pageSize);

        if (page < 0) {
            this.page = 0;
        } else if (page > this.pageCount) {
            if(this.pageCount == 0){
                this.page = page - 1;
            }else{
                this.page = this.pageCount - 1;
            }
        } else {
            this.page = page - 1;
        }
    }

    public int getItems() {
        return items;
    }

    public Integer getPage() {
        return page;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public Integer getPageSize() {
        return pageSize;
    }
}

