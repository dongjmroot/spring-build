package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 操作日志注解
 *
 * @author dongjiaming
 * @date 2022/08/19
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface OperationLog {

    /**
     * 操作名称
     *
     * @return {@link String}
     */
    String value();

    /**
     * 类型(1管理员操作 2普通用户的查询操作 3普通用户编辑操作)
     *
     * @return int
     */
    int type();
}
