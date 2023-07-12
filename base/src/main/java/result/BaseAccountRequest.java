package result;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author dongjiaming
 * @Description
 * @title: BaseAccountRequest
 * @projectName study
 * @date 2022/4/3020:24
 */
@Data
public class BaseAccountRequest {

    private String userUuid;

    /**
     * 主键
     */
    private Long id;


    private String username;

    private String password;

    private String salt;


    private String email;

    private Integer type;

    private String status;

    private String headerUrl;

    private Date createTime;

    private Integer coin;

    private String careerDirection;

    private String hobby;

    private String isVip;

    @ApiModelProperty(value = "vip剩余天数")
    private Integer vipLeftDays;

    private String userAddressProvince;

    private String userAddressCity;

    private String userAddressRegion;

    private Date updateUsernameTime;

}
