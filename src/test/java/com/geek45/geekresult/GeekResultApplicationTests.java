package com.geek45.geekresult;

import com.alibaba.fastjson.JSON;
import com.geek45.geekresult.annotation.aspect.ExceptionHandlerAspect;
import com.geek45.geekresult.exception.BizException;
import com.geek45.geekresult.exception.SystemException;
import com.geek45.geekresult.exception.ValidationException;
import com.geek45.geekresult.util.LoggerUtils;
import com.geek45.geekresult.vo.ResultVO;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {ValidatorServiceTest.class, ExceptionHandlerAspect.class})
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ComponentScan({"com.geek45"})
public class GeekResultApplicationTests {
    private static final Logger logger = LoggerUtils.SYSTEM_LOGGER;

    public GeekResultApplicationTests() {

    }

    @Autowired
    private ValidatorServiceTest validatorServiceTest;

    @Test
    public void checkEquals() {
        System.err.println(StringUtils.equalsIgnoreCase("123", "123"));
        System.err.println(StringUtils.equalsIgnoreCase(null, "123"));
        System.err.println(StringUtils.equalsIgnoreCase(null, null));
        System.err.println(StringUtils.equalsIgnoreCase("123", null));

        System.err.println(StringUtils.equals("123", "123"));
        System.err.println(StringUtils.equals(null, "123"));
        System.err.println(StringUtils.equals(null, null));
        System.err.println(StringUtils.equals("123", null));
    }

    @Test
//    @DisplayName("测试校验异常类")
    public void checkValidator() {
        logger.info("action check");
        ResultVO result = validatorServiceTest.testValidatorSuccess();
        if (!result.isSuccess()) {
            throw ValidationException.createValidationException(result.getThrowable());
        }
        ResultVO bizException = validatorServiceTest.testError(BizException.class);
        logger.error("bizException exception ..{}", JSON.toJSONString(bizException), bizException.getThrowable());

        ResultVO validatorException = validatorServiceTest.testError(ValidationException.class);
        logger.error("validatorException exception ..{}", JSON.toJSONString(validatorException), validatorException.getThrowable());

        ResultVO systemException = validatorServiceTest.testError(SystemException.class);
        logger.error("systemException exception ..{}", JSON.toJSONString(systemException), systemException.getThrowable());


    }

}
