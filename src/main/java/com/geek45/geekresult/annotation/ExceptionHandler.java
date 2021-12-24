/**
 * From geek45.com
 * Email to : rubixgeek795@gmail.com
 */
package com.geek45.geekresult.annotation;

import java.lang.annotation.*;

/**
 * @ClassName: ExceptionHandler
 * @Decription: 异常处理器
 * @Author: qian
 * qian create ExceptionHandler.java of 2021/12/24 11:19 下午
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ExceptionHandler {

}
