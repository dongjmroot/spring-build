package exception;

import cn.hutool.core.util.ObjectUtil;
import menu.CaryEnum;
import menu.ErrorCodeEnum;
import result.ResMessage;
import result.Res;

import java.util.List;

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

    public static void isTrue(Boolean obj, CaryEnum caryEnum) {
        if (!obj) {
            errorCodeEnumException(caryEnum);
        }
    }

    public static void isTrue(Res obj) {
        if (obj == null || obj.getError() == null) {
            errorCodeEnumException(ErrorCodeEnum.SystemException);
            return;
        }
        ResMessage resMessage = obj.getError();
        if (!resMessage.isSuccess()) {
            throw new CommonException(resMessage.getReturnCode(), resMessage.getReturnMessage());
        }
    }


    public static void errorCodeEnumException(CaryEnum caryEnum) {
        throw new CommonException(caryEnum);
    }


    public static void errorCodeEnumServiceException(CaryEnum caryEnum) {
        throw new ServiceException(caryEnum);
    }


}
