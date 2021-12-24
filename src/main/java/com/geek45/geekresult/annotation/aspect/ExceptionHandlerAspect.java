/**
 * From geek45.com
 * Email to : rubixgeek795@gmail.com
 */
package com.geek45.geekresult.annotation.aspect;

import com.alibaba.fastjson.JSON;
import com.geek45.geekresult.enums.ResultCodeEnums;
import com.geek45.geekresult.exception.BizException;
import com.geek45.geekresult.util.LoggerUtils;
import com.geek45.geekresult.vo.ResultVO;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;

/**
 * @ClassName: ExceptionHandlerAspect
 * @Decription:
 * @Author: qian
 * qian create ExceptionHandlerAspect.java of 2021/12/24 11:20 下午
 */
public class ExceptionHandlerAspect {
    private static final Logger logger = LoggerUtils.SYSTEM_LOGGER;

    @Pointcut("@annotation(com.geek45.geekresult.annotation.ExceptionHandler)")
    public void aroundCatchException() {}

    @Around("aroundCatchException")
    public Object aroundLogic(ProceedingJoinPoint proceedingJoinPoint) {
        String methodName = null;
        try {
            methodName = proceedingJoinPoint.getSignature().getName();
            Object proceed = proceedingJoinPoint.proceed();
            return proceed;
        } catch (BizException ex) {
            logger.error("process {} exception. args is :{},", methodName, JSON.toJSONString(proceedingJoinPoint.getArgs()), ex);
            return ResultVO.error(ex, ResultCodeEnums.BIZ_EXCEPTION.name(), ex.getMessage());
        }  catch (Throwable th) {
            logger.error("process {} exception. args is :{},", methodName, JSON.toJSONString(proceedingJoinPoint.getArgs()), th);
            return ResultVO.error(th, ResultCodeEnums.SYSTEM_ERROR.name(), th.getMessage());
        }
    }

}
