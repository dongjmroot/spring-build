package result;

import exception.CommonException;
import exception.ServiceException;
import menu.CommonEnum;
import menu.CommonResponseEnum;
import page.DataListVO;
import page.PageDataListVO;
import page.PageList;
import utils.PaginatedBaseUtil;

import java.util.List;

/**
 * @author dongjiaming
 * @Description
 * @title: CommonResponseConfig
 * @projectName study
 * @date 2022/4/3020:29
 */
public class CommonResponseConfig {
    //成功：0
    private static CommonResponse<?> SUCCESS = new CommonResponse<>(CommonResponseEnum.Success);
    //系统异常
    private static CommonResponse<?> ERROR = new CommonResponse<>(CommonResponseEnum.Error);


    /**
     * 处理成功
     *
     * @return
     */
    public static CommonResponse<?> SUCCESS() {
        return new CommonResponse<>(SUCCESS.getCode(), SUCCESS.getMsg());
    }

    public static <T> CommonResponse<T> SUCCESS(T T) {
        CommonResponse<T> response = new CommonResponse<T>(SUCCESS.getCode(), SUCCESS.getMsg());
        response.setResult(T);
        return response;
    }

    /**
     * 处理失败
     *
     * @return
     */
    public static <T> CommonResponse<T> ERROR() {
        return new CommonResponse<>(ERROR.getCode(), ERROR.getMsg());
    }

    public static <T> CommonResponse<T> ERROR(String code, String returnMessage) {
        return new CommonResponse<T>(code, returnMessage);
    }

    public static <T> CommonResponse<T> ERROR(CommonResponseEnum commonResponseEnum) {
        return new CommonResponse<T>(commonResponseEnum.getCode(), commonResponseEnum.getDescription());
    }

    public static <T> CommonResponse<T> ERROR(CommonEnum commonEnum) {
        return new CommonResponse<T>(commonEnum.getCode(), commonEnum.getDescription());
    }

    public static <T> CommonResponse<T> ERROR(ResultMessage resultMessage) {
        return new CommonResponse<T>(resultMessage.getReturnCode(), resultMessage.getReturnMessage());
    }

    public static <T> CommonResponse<T> ERROR(String message) {
        return new CommonResponse<>(ERROR.getCode(), message);
    }

    public static <T> CommonResponse<T> ERROR(Class<T> clazz) {
        return new CommonResponse<T>(ERROR.getCode(), ERROR.getMsg());
    }



    public static CommonResponse failure(String returnCode, String returnMessage) {
        return new CommonResponse(returnCode, returnMessage);
    }

    public static CommonResponse failure(CommonEnum commonEnum) {
        return new CommonResponse(commonEnum.getCode(), commonEnum.getDescription());
    }

    public static CommonResponse failure(CommonException commonException) {
        if (commonException.getCanaryEnum() != null) {
            return failure(commonException.getCanaryEnum());
        }
        return new CommonResponse(commonException.getCode(), commonException.getMsg());
    }

    public static CommonResponse failure(ServiceException serviceException) {
        if (serviceException.getCanaryEnum() != null) {
            return failure(serviceException.getCanaryEnum());
        }
        return new CommonResponse(serviceException.getCode(), serviceException.getMsg());
    }

    public static CommonResponse failure() {
        return new CommonResponse(CommonResponseEnum.Error);
    }

    public static CommonResponse failure(CommonResponseEnum commonResponseEnum) {
        return new CommonResponse(commonResponseEnum);
    }


    public static <T> CommonResponse<T> failure(CommonResponseEnum commonResponseEnum, T dataT) {
        return new CommonResponse(commonResponseEnum, dataT);
    }

    public static <T> CommonResponse<T> failure(CommonEnum commonEnum, T T) {
        CommonResponse<T> response = new CommonResponse(commonEnum.getCode(), commonEnum.getDescription());
        response.setResult(T);
        return response;
    }


    public static <T> CommonResponse<T> convert(Result<T> T) {
        ResultMessage resultMessage = T.getError();
        if (resultMessage == null) {
            return CommonResponseConfig.failure();
        }
        if (resultMessage.isSuccess()) {
            return CommonResponse.success(resultMessage.getReturnMessage(), T.getData());
        } else {
            return CommonResponseConfig.failure(resultMessage.getReturnCode(), resultMessage.getReturnMessage());
        }
    }

    public static <T> CommonResponse<T> convert(BaseResult baseResult) {
        if (baseResult == null) {
            return CommonResponseConfig.failure();
        }
        if (baseResult.isSuccess()) {
            return CommonResponse.success(baseResult.getErrorMsg());
        }
        return CommonResponseConfig.failure(baseResult.getCode(), baseResult.getErrorMsg());

    }

    public static <E> CommonResponse<PageList<E>> convertPage(Result<PageDataListVO<E>> result, PageRequestCommon pageRequestBase) {
        return convertPage(result, pageRequestBase.getPageNum(), pageRequestBase.getPageSize());
    }

    public static <E> CommonResponse<PageList<E>> convertPage(Result<PageDataListVO<E>> result, int pageNum, int pageSize) {
        ResultMessage resultMessage = result.getError();
        if (resultMessage == null) {
            return CommonResponseConfig.failure();
        }
        if (resultMessage.isSuccess()) {
            PageDataListVO<E> pageDataListVO = result.getData();
            PageList<E> paginatedList = new PageList<>(pageDataListVO.getData(), PaginatedBaseUtil.getBasePaginator(pageDataListVO.getItems(), pageNum, pageSize));
            return CommonResponse.success(paginatedList);
        } else {
            return CommonResponseConfig.failure(resultMessage.getReturnCode(), resultMessage.getReturnMessage());
        }
    }

    public static <E> CommonResponse<DataListVO<E>> convertDataListVO(Result<List<E>> result) {
        ResultMessage resultMessage = result.getError();
        if (resultMessage == null) {
            return CommonResponseConfig.failure();
        }
        if (resultMessage.isSuccess()) {
            List<E> list = result.getData();
            return CommonResponse.success(new DataListVO<>(list));
        } else {
            return CommonResponseConfig.failure(resultMessage.getReturnCode(), resultMessage.getReturnMessage());
        }
    }

}
