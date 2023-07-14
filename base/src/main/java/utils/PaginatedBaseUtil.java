package utils;

import page.Paginator;

/**
 * @author dongjiaming
 * @Description
 * @title: PaginatedBaseUtil
 * @projectName study
 * @date 2022/4/3020:45
 */
public class PaginatedBaseUtil {

    public static Paginator getBasePaginator(int items, int pageNum, int pageSize) {
        return new Paginator(pageSize, items, pageNum);
    }
}
