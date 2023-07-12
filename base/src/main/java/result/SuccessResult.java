package result;

/**
 * @author dongjiaming
 * @Description
 * @title: SuccessResult
 * @projectName study
 * @date 2022/4/3020:48
 */
public class SuccessResult<T> extends AbstractResult<T> {
    public SuccessResult(ReMessage error, T dataT) {
        super(error, dataT);
    }

    public SuccessResult(String msg, T dataT) {
        super("0", msg, dataT);
    }

    public SuccessResult(ReMessage error) {
        super(error, (T) null);
    }

    public SuccessResult() {
        super("0", "请求成功", null);
    }

    public SuccessResult(String msg) {
        super("0", msg, null);
    }

    public SuccessResult(T dataT) {
        super("0", "请求成功", dataT);
    }


    public static SuccessResult successResultDateMsg(String dataMsg) {
        return new SuccessResult("操作成功", dataMsg);
    }

    public static SuccessResult success(String msg) {
        return new SuccessResult(msg);
    }

    public static SuccessResult success(String msg, String dataMsg) {
        return new SuccessResult(msg, dataMsg);
    }

    public static <T> SuccessResult<T> success(T data) {
        return new SuccessResult(data);
    }

    public static SuccessResult success() {
        return new SuccessResult();
    }


}
