package result;

import lombok.Data;

/**
 * @author dongjiaming
 * @Description
 * @title: PageRequestCommon
 * @projectName study
 * @date 2022/4/3020:42
 */
@Data
public class PageRequestCommon extends CommonRequest {


    private static final long serialVersionUID = -7338144147512071601L;

    /**
     * 总条数
     */
    private int totalItems;
    /**
     * 必选，每页条数
     */
    private int pageSize;

    /**
     * 当前页码
     */
    private int pageNum;

    /**
     * 1上一页  2下一页
     */
    private int goPageType;

    private int limitBegin;

    private Long items;

    private String sortCol;

    private String sortDir;


    public PageRequestCommon() {

    }

    public PageRequestCommon(int pageNum, int pageSize) {
        this.setPageNum(pageNum);
        this.setPageSize(pageSize);
        this.setLimitBegin((this.pageNum - 1) * this.pageSize);
    }

    public void setPageSize(int pageSize) {
        pageSize = Math.max(pageSize, 1);
        this.pageSize = pageSize;
    }

    public void setPageNum(int pageNum) {
        pageNum = Math.max(pageNum, 1);
        this.pageNum = pageNum;
    }

    /**
     * 根据总记录数计算总页数
     *
     * @return
     */
    public int getTotalPage(int totalItems) {
        if (pageSize == 0) {
            return 0;
        } else {
            return totalItems % pageSize == 0 ? totalItems / pageSize : (totalItems / pageSize + 1);
        }
    }

}

