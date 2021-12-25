/**
 * From geek45.com
 * Email to : rubixgeek795@gmail.com
 */
package com.geek45.geekresult;

import com.geek45.geekresult.annotation.ExceptionHandler;
import com.geek45.geekresult.exception.BizException;
import com.geek45.geekresult.exception.SystemException;
import com.geek45.geekresult.exception.ValidationException;
import com.geek45.geekresult.validator.ValidateUtils;
import com.geek45.geekresult.vo.ResultVO;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName: ValidatorServiceTest
 * @Decription: 测试校验
 * @Author: rubik
 *  rubik create ValidatorServiceTest.java of 2021/12/25 10:58 上午
 */
@Component
public class ValidatorServiceTest {

    @ExceptionHandler
    public ResultVO<Void> testValidatorSuccess() {
        String testStr = "";
        ValidateUtils.throwExceptionIfNotBlank(testStr);
        ValidateUtils.throwExceptionIfNotBlankWithDesc("数据为空为空", testStr);

        testStr = "123";
        ValidateUtils.throwExceptionIfAnyBlank(testStr);
        ValidateUtils.throwExceptionIfAnyBlankWithDesc("数据为空", testStr);

        ValidateUtils.throwExceptionIfEqualsFalse(testStr, "123");

        ValidateUtils.throwExceptionIfEqualsTrue(testStr, "344");
        ValidateUtils.throwExceptionIfEqualsTrueWithDesc("匹配", testStr, "453");

        ValidateUtils.throwExceptionIfTrue(StringUtils.isBlank(testStr));
        ValidateUtils.throwExceptionIfTrueWithDesc("不能为空", StringUtils.isBlank(testStr));

        ValidateUtils.throwExceptionIfFalse(StringUtils.isNotBlank(testStr));
        ValidateUtils.throwExceptionIfFalseWithDesc("需要为空", StringUtils.isNotBlank(testStr));


        List<String> list = Lists.newArrayList();
        ValidateUtils.throwExceptionIfNotEmpty(list);
        ValidateUtils.throwExceptionIfNotEmptyWithDesc("集合不能为空", list);

        list.add(testStr);
        ValidateUtils.throwExceptionIfEmpty(list);
        ValidateUtils.throwExceptionIfEmptyWithDesc("集合为空", list);

        return ResultVO.success();
    }

    @ExceptionHandler
    public ResultVO<Void> testError(Class<? extends RuntimeException> clazz) {
        if (clazz.getSimpleName().equals(BizException.class.getSimpleName())) {
            ValidateUtils.throwBizExceptionWithDesc("hello");
        }

        if (clazz.getSimpleName().equals(ValidationException.class.getSimpleName())) {
            ValidateUtils.throwValidatorExceptionWithDesc("hello");
        }

        if (clazz.getSimpleName().equals(SystemException.class.getSimpleName())) {
            ValidateUtils.throwSystemExceptionWithDesc("hello");
        }
        return ResultVO.success();
    }

}
