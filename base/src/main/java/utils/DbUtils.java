package utils;


import dto.Datasource;
import lombok.extern.slf4j.Slf4j;
import menu.DBTypeEnum;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Objects;

/**
 * DB工具类
 *
 * @author 阿沐 babamu@126.com
 */
@Slf4j
public class DbUtils {
    private static final int CONNECTION_TIMEOUTS_SECONDS = 6;

    /**
     * 获得数据库连接
     */
    public static Connection getConnection(Datasource dataSource) {
        Connection connection = null;
        try {
            DriverManager.setLoginTimeout(CONNECTION_TIMEOUTS_SECONDS);
            String dbType = dataSource.getDbType();

            Class.forName(Objects.requireNonNull(DBTypeEnum.get(dbType)).getValue());
            connection = DriverManager.getConnection(dataSource.getConnUrl(), dataSource.getUsername(), dataSource.getPassword());
        } catch (Exception e) {
            log.error("连接失败,原因{}", e.getMessage());
        }

        return connection;
    }


}
