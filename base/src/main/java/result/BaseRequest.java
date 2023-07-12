package result;

import java.io.Serializable;

/**
 * @author dongjiaming
 * @Description
 * @title: BaseRequest
 * @projectName study
 * @date 2022/4/3020:43
 */
public class BaseRequest implements Serializable {

    private static final long serialVersionUID = -3017060217838849411L;

    private String requestId;

    /**
     * 租户id
     */
    private String userUuid;

    /**
     * 账户
     */
    private String account;

    private String accessKeyID;


    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAccessKeyID() {
        return accessKeyID;
    }

    public void setAccessKeyID(String accessKeyID) {
        this.accessKeyID = accessKeyID;
    }

}
