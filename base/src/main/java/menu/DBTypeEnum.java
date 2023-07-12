package menu;

import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 活动审核枚举
 * </p>
 *
 * @Description 活动审核枚举
 * @Author dongjiaming
 * @Date 2022-6-27
 */
@Getter
public enum DBTypeEnum {

    SQLServer("SQLServer", "com.microsoft.sqlserver.jdbc.SQLServerDriver"),
    MySQL("MySQL", "com.mysql.cj.jdbc.Driver"),
    Oracle("Oracle", "oracle.jdbc.driver.OracleDriver"),
    PostgreSQL("PostgreSQL", "org.postgresql.Driver");

    public static Map<String, String> enumMap = Arrays.stream(DBTypeEnum.values())
            .collect(Collectors.toMap(DBTypeEnum::getCode, DBTypeEnum::getValue));
    private final String code;
    private final String value;

    DBTypeEnum(String code, String value) {
        this.code = code;
        this.value = value;

    }

    public static DBTypeEnum get(String code) {
        for (DBTypeEnum articleExamEnum : values()) {
            if (articleExamEnum.getCode().equals(code)) {
                return articleExamEnum;
            }
        }
        return null;
    }
}
