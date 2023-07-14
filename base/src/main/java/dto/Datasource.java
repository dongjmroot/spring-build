package dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;


import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 数据源管理实体
 * </p>
 *
 * @Description 数据源管理实体
 * @Author dongjiaming
 * @Date 2023-05-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "Datasource对象", description = "数据源管理")
public class Datasource implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "uuid")
    private String uuid;

    @ApiModelProperty(value = "数据库类型")
    private String dbType;

    @ApiModelProperty(value = "连接名")
    private String connName;

    @ApiModelProperty(value = "环境名")
    private String environment;

    @ApiModelProperty(value = "URL")
    private String connUrl;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "数据库名")
    private String datasource;

    @ApiModelProperty(value = "表名")
    private String table;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "是否测试通过")
    private String isOk;


}
