package com.mmail.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用来标记线程安全的类或写法
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE) //如果在项目中使用，使用RUNTIME
public @interface NotThreadSafe {
    String value() default "";
}
