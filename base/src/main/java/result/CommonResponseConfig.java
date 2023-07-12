package result;

import exception.CommonException;
import exception.ServiceException;
import menu.CommonResponseEnum;
import page.DataListVO;
import page.PageDataListVO;
import page.PageList;
import menu.CaryEnum;
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

    public static <T> CommonResponse<T> ERROR(CaryEnum caryEnum) {
        return new CommonResponse<T>(caryEnum.getCode(), caryEnum.getDescription());
    }

    public static <T> CommonResponse<T> ERROR(ResMessage resMessage) {
        return new CommonResponse<T>(resMessage.getReturnCode(), resMessage.getReturnMessage());
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

    public static CommonResponse failure(CaryEnum caryEnum) {
        return new CommonResponse(caryEnum.getCode(), caryEnum.getDescription());
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

    public static <T> CommonResponse<T> failure(CaryEnum caryEnum, T T) {
        CommonResponse<T> response = new CommonResponse(caryEnum.getCode(), caryEnum.getDescription());
        response.setResult(T);
        return response;
    }


    public static <T> CommonResponse<T> convert(Res<T> T) {
        ResMessage resMessage = T.getError();
        if (resMessage == null) {
            return CommonResponseConfig.failure();
        }
        if (resMessage.isSuccess()) {
            return CommonResponse.success(resMessage.getReturnMessage(), T.getData());
        } else {
            return CommonResponseConfig.failure(resMessage.getReturnCode(), resMessage.getReturnMessage());
        }
    }

    public static <T> CommonResponse<T> convert(ResultBase resultBase) {
        if (resultBase == null) {
            return CommonResponseConfig.failure();
        }
        if (resultBase.isSuccess()) {
            return CommonResponse.success(resultBase.getErrorMsg());
        }
        return CommonResponseConfig.failure(resultBase.getCode(), resultBase.getErrorMsg());

    }

    public static <E> CommonResponse<PageList<E>> convertPage(Res<PageDataListVO<E>> res, PageRequestCommon pageRequestBase) {
        return convertPage(res, pageRequestBase.getPageNum(), pageRequestBase.getPageSize());
    }

    public static <E> CommonResponse<PageList<E>> convertPage(Res<PageDataListVO<E>> res, int pageNum, int pageSize) {
        ResMessage resMessage = res.getError();
        if (resMessage == null) {
            return CommonResponseConfig.failure();
        }
        if (resMessage.isSuccess()) {
            PageDataListVO<E> pageDataListVO = res.getData();
            PageList<E> paginatedList = new PageList<>(pageDataListVO.getData(), PaginatedBaseUtil.getBasePaginator(pageDataListVO.getItems(), pageNum, pageSize));
            return CommonResponse.success(paginatedList);
        } else {
            return CommonResponseConfig.failure(resMessage.getReturnCode(), resMessage.getReturnMessage());
        }
    }

    public static <E> CommonResponse<DataListVO<E>> convertDataListVO(Res<List<E>> res) {
        ResMessage resMessage = res.getError();
        if (resMessage == null) {
            return CommonResponseConfig.failure();
        }
        if (resMessage.isSuccess()) {
            List<E> list = res.getData();
            return CommonResponse.success(new DataListVO<>(list));
        } else {
            return CommonResponseConfig.failure(resMessage.getReturnCode(), resMessage.getReturnMessage());
        }
    }

}
