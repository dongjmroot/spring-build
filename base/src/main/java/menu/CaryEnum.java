package menu;

/**
 * @author dongjiaming
 * @Description
 * @title: CaryEnum
 * @projectName study
 * @date 2022/4/3019:46
 */
public interface CaryEnum {
    /**
     * 获取枚举代码
     *
     * @return 枚举代码
     */
    public String getCode();

    /**
     * 获取枚举描述
     *
     * @return 枚举描述
     */
    public String getDescription();

    public Integer getResultCode();

    public String getCodeMessage();
}
