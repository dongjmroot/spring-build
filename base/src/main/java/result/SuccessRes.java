package result;

/**
 * @author dongjiaming
 * @Description
 * @title: SuccessRes
 * @projectName study
 * @date 2022/4/3020:48
 */
public class SuccessRes<T> extends AbstractRes<T> {
    public SuccessRes(ResMessage error, T dataT) {
        super(error, dataT);
    }

    public SuccessRes(String msg, T data) {
        super("0", msg, data);
    }

    public SuccessRes(ResMessage error) {
        super(error, (T) null);
    }

    public SuccessRes() {
        super("0", "请求成功", null);
    }

    public SuccessRes(String msg) {
        super("0", msg, null);
    }

    public SuccessRes(T data) {
        super("0", "请求成功", data);
    }


    public static SuccessRes successResultDateMsg(String dataMsg) {
        return new SuccessRes("操作成功", dataMsg);
    }

    public static SuccessRes success(String msg) {
        return new SuccessRes(msg);
    }

    public static SuccessRes success(String msg, String dataMsg) {
        return new SuccessRes(msg, dataMsg);
    }

    public static <T> SuccessRes<T> success(T data) {
        return new SuccessRes(data);
    }

    public static SuccessRes success() {
        return new SuccessRes();
    }


}
