package result;

import java.io.Serializable;

/**
 * @author dongjiaming
 * @Description
 * @title: CommonRequest
 * @projectName study
 * @date 2022/4/3020:43
 */
public class CommonRequest implements Serializable {

    private static final long serialVersionUID = -30170602178849411L;

    private String requestId;


    /**
     * 租户id
     */
    private String userUuid;

    /**
     * 账户
     */
    private String account;



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
}
