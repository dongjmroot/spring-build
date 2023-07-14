package page;


import exception.Assert;

import io.swagger.annotations.ApiModelProperty;
import menu.ErrorCodeEnum;

import java.io.Serializable;

/**
 * @author dongjiaming
 * @Description
 * @title: CommonSearchPageForm
 * @projectName study
 * @date 2022/4/3020:26
 */
public class CommonSearchPageForm implements Serializable {
    private static final long serialVersionUID = -1399517909665618921L;
    @ApiModelProperty(
            value = "第几页",
            notes = "默认为0",
            example = "0"
    )
    private int page;
    @ApiModelProperty(
            value = "每页项数",
            notes = "默认为1,不可大于200",
            example = "1"
    )
    private Integer pageSize;

    public CommonSearchPageForm() {
    }

    public int getPage() {
        return this.page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    @ApiModelProperty(
            hidden = true
    )
    public int getPageNum() {
        return this.page + 1;
    }

    public Integer getPageSize() {
        if (this.pageSize == null || this.pageSize <= 0) {
            Assert.errorCodeEnumException(ErrorCodeEnum.InvalidPageParams);
        }

        return this.pageSize;
    }

    public void setPageSize(Integer pageSize) {
        if (pageSize == null) {
            pageSize = 1;
        }

        pageSize = pageSize < 1 ? 1 : pageSize;
        Assert.isTrue(pageSize <= 200, ErrorCodeEnum.InvalidPageParams);
        this.pageSize = pageSize;
    }
}
