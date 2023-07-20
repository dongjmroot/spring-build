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
    private static final long serialVersionUID = -882244055485069L;


    public static final int DEFAULT_ITEMS_PER_PAGE = 10;

    /**
     * 总项数
     */
    private int items;

    /**
     * 当前页号
     */
    private final Integer currentPage;

    /**
     * 总页数
     */
    private final Integer pageCount;

    /**
     * 每页显示的数
     */
    private final Integer pageSize;

    public Paginator(int pageSize, int items, int currentPage) {
        this.items = Math.max(items, 0);
        this.pageSize = (pageSize > 0) ? pageSize : DEFAULT_ITEMS_PER_PAGE;
        this.pageCount = (int) Math.ceil((double) items / pageSize);

        if (currentPage < 0) {
            this.currentPage = 0;
        } else if (currentPage > this.pageCount) {
            if (this.pageCount == 0) {
                this.currentPage = currentPage - 1;
            } else {
                this.currentPage = this.pageCount - 1;
            }
        } else {
            this.currentPage = currentPage - 1;
        }
    }

    public int getItems() {
        return items;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public Integer getPageSize() {
        return pageSize;
    }
}

