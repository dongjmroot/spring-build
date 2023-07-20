package page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dongjiaming
 * @Description
 * @title: PageList
 * @projectName study
 * @date 2022/4/3020:36
 */
@Data
@ApiModel(description = "分页对象")
public class PageList<T> implements Serializable {

    private static final long serialVersionUID = -5307326305768010526L;
    /**
     * 分页项目
     */
    @ApiModelProperty(value = "对象列表")
    private final List<T> data;

    @ApiModelProperty(value = "总条数")
    private Integer items;

    /**
     * 当前页号
     */
    @ApiModelProperty(value = "当前页号")
    private final Integer currentPage;

    /**
     * 总页数
     */
    @ApiModelProperty(value = "总页数")
    private final Integer pageCount;

    /**
     * 每页显示的数
     */
    @ApiModelProperty(value = "pageSize")
    private final Integer pageSize;


    public PageList(List<T> list, Paginator paginator) {
        this.data = (list == null) ? new ArrayList<T>() : list;
        this.currentPage = paginator.getCurrentPage();
        this.pageCount = paginator.getPageCount();
        this.pageSize = paginator.getPageSize();
        this.items = paginator.getItems();
    }





}
