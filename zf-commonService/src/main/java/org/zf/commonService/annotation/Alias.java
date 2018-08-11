package org.zf.commonService.annotation;


import java.lang.annotation.*;

/**
 * Title：bmis
 * Class：com.bmis.webservice.model
 * Comapny:杭州同烁信息技术有限公司
 *
 * @author：周陈伟
 * @version：2.5 CreateTime：2017/4/19 14:34
 * Modify log:
 * Description：
 */
@Target({ElementType.PARAMETER, ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Alias {
    String name()  default "";
}
