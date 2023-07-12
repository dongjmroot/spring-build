package exception;

import com.study.base.result.ReMessage;
import com.study.base.result.Result;
import com.study.constant.sys.CanaryEnum;
import com.study.constant.sys.ErrorCodeSystemEnum;

import java.util.List;

/**
 * @author dongjiaming
 * @Description
 * @title: Assert
 * @projectName study
 * @date 2022/4/3020:15
 */
public class Assert {

    //private static final CommonLogger log = CommonLoggerFactory.getLogger(Assert.class);


    protected Assert() {
    }

    public static void notNull(Object obj, String message) {
        if (obj == null) {
            throw new BaseException(message);
        }
    }

    public static void isTrue(Boolean obj, String message) {
        if (!obj) {
            throw new BaseException(message);
        }
    }

    public static void isTrue(Result result, CanaryEnum canaryEnum) {
        if (result == null) {
            errorCodeEnumException(canaryEnum);
        } else {
            if (result.getError() == null || !result.getError().isSuccess()) {
                errorCodeEnumException(canaryEnum);
            }
        }
    }


    public static void notBlank(String obj, String message) {
        if (obj == null || "".equals(obj.trim())) {
            throw new BaseException(message);
        }
    }

    public static void notEmpty(List<?> objList, String message) {
        if (objList == null || objList.size() == 0) {
            throw new BaseException(message);
        }
    }

    public static void notZero(long obj, String message) {
        if (obj == 0) {
            throw new BaseException(message);
        }
    }

    public static void notZero(Long obj, CanaryEnum canaryEnum) {
        if (obj == null || obj == 0) {
            errorCodeEnumException(canaryEnum);
        }
    }


    public static void notBlank(String obj, CanaryEnum canaryEnum) {
        if (obj == null || "".equals(obj.trim())) {
            errorCodeEnumException(canaryEnum);
        }
    }

    public static void notNull(Object obj, CanaryEnum canaryEnum) {
        if (obj == null) {
            errorCodeEnumException(canaryEnum);
        }
    }

    public static void notNull(Object obj, CanaryEnum canaryEnum, String msg) {
        if (obj == null) {
            //log.info(msg);
            errorCodeEnumException(canaryEnum);
        }
    }

    public static void isTrue(Boolean obj, CanaryEnum canaryEnum) {
        if (!obj) {
            errorCodeEnumException(canaryEnum);
        }
    }

    public static void isTrue(Result obj) {
        if (obj == null || obj.getError() == null) {
            errorCodeEnumException(ErrorCodeSystemEnum.SystemException);
            return;
        }
        ReMessage reMessage = obj.getError();
        if (!reMessage.isSuccess()) {
            throw new BaseException(reMessage.getReturnCode(), reMessage.getReturnMessage());
        }
    }


    public static void isTrue(Boolean obj, CanaryEnum canaryEnum, String msg) {
        if (!obj) {
            //log.info(msg);
            errorCodeEnumException(canaryEnum);
        }
    }

    public static void notEmpty(List<?> objList, CanaryEnum canaryEnum) {
        if (objList == null || objList.size() == 0) {
            errorCodeEnumException(canaryEnum);
        }
    }


    public static void errorCodeEnumException(CanaryEnum canaryEnum) {
        throw new BaseException(canaryEnum);
    }

    public static void errorCodeEnumException(String code, String message) {
        throw new BaseException(code, message);
    }

    public static void errorCodeEnumException(CanaryEnum canaryEnum, Object... args) {
        String msg = canaryEnum.getDescription();
        String code = canaryEnum.getCode();
        throw new BaseException(code, String.format(msg, args));
    }


    public static void isTrueServiceException(Boolean obj, CanaryEnum canaryEnum) {
        if (!obj) {
            errorCodeEnumServiceException(canaryEnum);
        }
    }

    public static void isTrueServiceException(Boolean obj, String message) {
        if (!obj) {
            throw new ServiceException(message);
        }
    }

    public static void errorCodeEnumServiceException(CanaryEnum canaryEnum) {
        throw new ServiceException(canaryEnum);
    }


}
