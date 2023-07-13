package annotation;





import java.lang.annotation.*;

/**
 * @author dongjiaming
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RateLimiter {


    String key() default "rate_limit:";


    int time() default 60;


    int count() default 100;



}
