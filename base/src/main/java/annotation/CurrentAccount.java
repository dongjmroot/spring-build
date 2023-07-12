package annotation;

/**
 * @author dongjiaming
 * @Description
 * @title: CurrentAccount
 * @projectName study
 * @date 2022/4/3020:19
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface CurrentAccount {
    /**
     * 模式
     * 1 必须登录
     * 2 可登录可不登录
     *
     * @return int
     */
    int mode() default 1;

    String value() default "user";

}
