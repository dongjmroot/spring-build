package utils;

import lombok.extern.slf4j.Slf4j;

/**
 * @author dongjiaming
 * @Description 数据格式转换器
 * @title: DataTypeConvertUtils
 * @projectName study
 * @date 2023/5/1818:11
 */
@Slf4j
public class DataTypeConvertUtils {
    /**
     * 数据类型转化JAVA
     *
     * @param sqlType：类型名称
     * @return String
     */
    public static String toSqlToJava(String sqlType) {
        if (sqlType == null || sqlType.trim().length() == 0) {
            return sqlType;
        }
        sqlType = sqlType.toLowerCase();
        switch (sqlType) {
            case "nvarchar":
                return "String";
            case "char":
                return "String";
            case "varchar":
                return "String";
            case "text":
                return "String";
            case "nchar":
                return "String";
            case "blob":
                return "byte[]";
            case "integer":
                return "Long";
            case "tinyint":
                return "Integer";
            case "smallint":
                return "Integer";
            case "mediumint":
                return "Integer";
            case "bit":
                return "Boolean";
            case "bigint":
                return "Integer";
            case "float":
                return "Fload";
            case "double":
                return "Double";
            case "decimal":
                return "BigDecimal";
            case "boolean":
                return "Boolean";
            case "id":
                return "Long";
            case "int":
                return "Long";
            //时间类型就当String类型处理
            case "date":
                return "String";
            case "datetime":
                return "String";
            case "year":
                return "String";
            case "time":
                return "String";
            case "timestamp":
                return "String";
            case "numeric":
                return "BigDecimal";
            case "real":
                return "BigDecimal";
            case "money":
                return "Double";
            case "smallmoney":
                return "Double";
            case "image":
                return "byte[]";
            default:
                log.error("转化失败：未发现的类型{}",sqlType);
                System.out.println("-----------------》转化失败：未发现的类型" + sqlType);
                break;
        }
        return sqlType;
    }
}
