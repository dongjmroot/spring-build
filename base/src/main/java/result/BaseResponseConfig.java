package result;

import exception.BaseException;
import exception.ServiceException;
import page.DataListVO;
import page.PageDataListVO;
import page.PageList;
import menu.BaseResponseEnum;
import menu.CanaryEnum;
import utils.PaginatedBaseUtil;

import java.util.List;

/**
 * @author dongjiaming
 * @Description
 * @title: BaseResponseConfig
 * @projectName study
 * @date 2022/4/3020:29
 */
public class BaseResponseConfig {
    //成功：0
    private static BaseResponse<?> SUCCESS = new BaseResponse<>(BaseResponseEnum.Success);
    //系统异常
    private static BaseResponse<?> ERROR = new BaseResponse<>(BaseResponseEnum.Error);


    /**
     * 处理成功
     *
     * @return
     */
    public static BaseResponse<?> SUCCESS() {
        return new BaseResponse<>(SUCCESS.getCode(), SUCCESS.getMsg());
    }

//    public static BaseResponse<?> SUCCESS(String message) {
//        return new BaseResponse<>(SUCCESS.getCode(), message);
//    }

    //    public static <T> BaseResponse<T> SUCCESS(Class<T> clazz) {
//        return new BaseResponse<T>(SUCCESS.getCode(), SUCCESS.getErrorMessage());
//    }
    public static <T> BaseResponse<T> SUCCESS(T T) {
        BaseResponse<T> response = new BaseResponse<T>(SUCCESS.getCode(), SUCCESS.getMsg());
        response.setResult(T);
        return response;
    }


    /**
     * 处理失败
     *
     * @return
     */
    public static <T> BaseResponse<T> ERROR() {
        return new BaseResponse<>(ERROR.getCode(), ERROR.getMsg());
    }

    public static <T> BaseResponse<T> ERROR(String code, String returnMessage) {
        return new BaseResponse<T>(code, returnMessage);
    }

    public static <T> BaseResponse<T> ERROR(BaseResponseEnum baseResponseEnum) {
        return new BaseResponse<T>(baseResponseEnum.getCode(), baseResponseEnum.getDescription());
    }

    public static <T> BaseResponse<T> ERROR(CanaryEnum canaryEnum) {
        return new BaseResponse<T>(canaryEnum.getCode(), canaryEnum.getDescription());
    }

    public static <T> BaseResponse<T> ERROR(ReMessage reMessage) {
        return new BaseResponse<T>(reMessage.getReturnCode(), reMessage.getReturnMessage());
    }

    //
//
    public static <T> BaseResponse<T> ERROR(String message) {
        return new BaseResponse<>(ERROR.getCode(), message);
    }

    public static <T> BaseResponse<T> ERROR(Class<T> clazz) {
        return new BaseResponse<T>(ERROR.getCode(), ERROR.getMsg());
    }



    public static BaseResponse failure(String returnCode, String returnMessage) {
        return new BaseResponse(returnCode, returnMessage);
    }

    public static BaseResponse failure(CanaryEnum canaryEnum) {
        return new BaseResponse(canaryEnum.getCode(), canaryEnum.getDescription());
    }

    public static BaseResponse failure(BaseException baseException) {
        if (baseException.getCanaryEnum() != null) {
            return failure(baseException.getCanaryEnum());
        }
        return new BaseResponse(baseException.getCode(), baseException.getMsg());
    }

    public static BaseResponse failure(ServiceException serviceException) {
        if (serviceException.getCanaryEnum() != null) {
            return failure(serviceException.getCanaryEnum());
        }
        return new BaseResponse(serviceException.getCode(), serviceException.getMsg());
    }

    public static BaseResponse failure() {
        return new BaseResponse(BaseResponseEnum.Error);
    }

    public static BaseResponse failure(BaseResponseEnum baseResponseEnum) {
        return new BaseResponse(baseResponseEnum);
    }


    public static <T> BaseResponse<T> failure(BaseResponseEnum baseResponseEnum, T dataT) {
        return new BaseResponse(baseResponseEnum, dataT);
    }

    public static <T> BaseResponse<T> failure(CanaryEnum canaryEnum, T T) {
        BaseResponse<T> response = new BaseResponse(canaryEnum.getCode(), canaryEnum.getDescription());
        response.setResult(T);
        return response;
    }


    public static <T> BaseResponse<T> convert(Result<T> T) {
        ReMessage reMessage = T.getError();
        if (reMessage == null) {
            return BaseResponseConfig.failure();
        }
        if (reMessage.isSuccess()) {
            return BaseResponse.success(reMessage.getReturnMessage(), T.getData());
        } else {
            return BaseResponseConfig.failure(reMessage.getReturnCode(), reMessage.getReturnMessage());
        }
    }

    public static <T> BaseResponse<T> convert(ResultBase resultBase) {
        if (resultBase == null) {
            return BaseResponseConfig.failure();
        }
        if (resultBase.isSuccess()) {
            return BaseResponse.success(resultBase.getErrorMsg());
        }
        return BaseResponseConfig.failure(resultBase.getCode(), resultBase.getErrorMsg());

    }

    public static <E> BaseResponse<PageList<E>> convertPage(Result<PageDataListVO<E>> result, PageRequestBase pageRequestBase) {
        return convertPage(result, pageRequestBase.getPageNum(), pageRequestBase.getPageSize());
    }

    public static <E> BaseResponse<PageList<E>> convertPage(Result<PageDataListVO<E>> result, int pageNum, int pageSize) {
        ReMessage reMessage = result.getError();
        if (reMessage == null) {
            return BaseResponseConfig.failure();
        }
        if (reMessage.isSuccess()) {
            PageDataListVO<E> pageDataListVO = result.getData();
            PageList<E> paginatedList = new PageList<>(pageDataListVO.getData(), PaginatedBaseUtil.getBasePaginator(pageDataListVO.getItems(), pageNum, pageSize));
            return BaseResponse.success(paginatedList);
        } else {
            return BaseResponseConfig.failure(reMessage.getReturnCode(), reMessage.getReturnMessage());
        }
    }

    public static <E> BaseResponse<DataListVO<E>> convertDataListVO(Result<List<E>> result) {
        ReMessage reMessage = result.getError();
        if (reMessage == null) {
            return BaseResponseConfig.failure();
        }
        if (reMessage.isSuccess()) {
            List<E> list = result.getData();
            return BaseResponse.success(new DataListVO<>(list));
        } else {
            return BaseResponseConfig.failure(reMessage.getReturnCode(), reMessage.getReturnMessage());
        }
    }

}
