package page;

import com.study.base.exception.Assert;
import com.study.constant.sys.ErrorCodeSystemEnum;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author dongjiaming
 * @Description
 * @title: BaseSearchPageForm
 * @projectName study
 * @date 2022/4/3020:26
 */
public class BaseSearchPageForm implements Serializable {
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

    public BaseSearchPageForm() {
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
            Assert.errorCodeEnumException(ErrorCodeSystemEnum.InvalidPageParams);
        }

        return this.pageSize;
    }

    public void setPageSize(Integer pageSize) {
        if (pageSize == null) {
            pageSize = 1;
        }

        pageSize = pageSize < 1 ? 1 : pageSize;
        Assert.isTrue(pageSize <= 200, ErrorCodeSystemEnum.InvalidPageParams);
        this.pageSize = pageSize;
    }
}
