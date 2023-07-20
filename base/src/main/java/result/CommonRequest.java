package result;

import lombok.Data;

import java.io.Serializable;

/**
 * @author dongjiaming
 * @Description
 * @title: CommonRequest
 * @projectName study
 * @date 2022/4/3020:43
 */
@Data
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

}
