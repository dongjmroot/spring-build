package exception;

import cn.hutool.core.util.ObjectUtil;
import menu.CommonEnum;
import menu.ErrorCodeEnum;
import result.ResultMessage;
import result.Result;

/**
 * @author dongjiaming
 * @Description
 * @title: Assert
 * @projectName study
 * @date 2022/4/3020:15
 */
public class Assert {

    protected Assert() {
    }

    public static void notNull(Object obj, String message) {
        if (ObjectUtil.isNull(obj)) {
            throw new CommonException(message);
        }
    }

    public static void isTrue(Boolean obj, String message) {
        if (!obj) {
            throw new CommonException(message);
        }
    }

    public static void isTrue(Boolean obj, CommonEnum commonEnum) {
        if (!obj) {
            errorCodeEnumException(commonEnum);
        }
    }

    public static void isTrue(Result obj) {
        if (obj == null || obj.getError() == null) {
            errorCodeEnumException(ErrorCodeEnum.SystemException);
            return;
        }
        ResultMessage resultMessage = obj.getError();
        if (!resultMessage.isSuccess()) {
            throw new CommonException(resultMessage.getReturnCode(), resultMessage.getReturnMessage());
        }
    }


    public static void errorCodeEnumException(CommonEnum commonEnum) {
        throw new CommonException(commonEnum);
    }


    public static void errorCodeEnumServiceException(CommonEnum commonEnum) {
        throw new ServiceException(commonEnum);
    }


}
