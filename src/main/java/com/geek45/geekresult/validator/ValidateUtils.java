/**
 * From geek45.com
 * Email to : rubixgeek795@gmail.com
 */
package com.geek45.geekresult.validator;

import com.geek45.geekresult.enums.ResultCodeEnums;
import com.geek45.geekresult.exception.BizException;
import com.geek45.geekresult.exception.ValidationException;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Collection;

/**
 * @ClassName: ValidateUtils
 * @Decription:
 * @Author: rubik
 * rubik create ValidateUtils.java of 2021/12/24 10:34 下午
 */
public class ValidateUtils {

    /**
     * 抛出校验异常
     */
    public static void throwValidatorException() {
        throwValidatorExceptionWithDesc(ResultCodeEnums.VALIDATION.getDesc());
    }

    /**
     * 抛出校验异常
     * @param desc
     */
    public static void throwValidatorExceptionWithDesc(String desc) {
        throw ValidationException.createValidationException(desc);
    }

    /**
     * 抛出业务异常
     */
    public static void throwBizException() {
        throwBizExceptionWithDesc(ResultCodeEnums.BIZ_EXCEPTION.getDesc());
    }

    /**
     * 抛出业务异常
     * @param desc
     */
    public static void throwBizExceptionWithDesc(String desc) {
        throw BizException.createBizException(desc);
    }

    /**
     * 如果为false就抛出异常
     * @param v
     */
    public static void throwExceptionIfFalse(boolean v) {
        throwExceptionIfFalseWithDesc(ResultCodeEnums.VALIDATION.getDesc(), v);
    }

    /**
     * 如果为false就抛出异常
     * @param desc
     * @param v
     */
    public static void throwExceptionIfFalseWithDesc(String desc, boolean v) {
        if (!v) {
            throw ValidationException.createValidationException(desc);
        }
    }

    /**
     * 如果为true就抛出异常
     * @param v
     */
    public static void throwExceptionIfTrue(boolean v) {
        throwExceptionIfTrueWithDesc(ResultCodeEnums.VALIDATION.getDesc(), v);
    }

    /**
     * 如果为true就抛出异常
     * @param desc
     * @param v
     */
    public static void throwExceptionIfTrueWithDesc(String desc, boolean v) {
        if (v) {
            throw ValidationException.createValidationException(desc);
        }
    }

    /**
     * 如果不为空，就抛出异常
     * @param coll
     */
    public static void throwExceptionIfNotEmpty(Collection<?> coll) {
        throwExceptionIfNotEmptyWithDesc(ResultCodeEnums.VALIDATION.getDesc(), coll);
    }

    /**
     * 如果不为空，就抛出异常
     * @param desc
     * @param coll
     */
    public static void throwExceptionIfNotEmptyWithDesc(String desc, Collection<?> coll) {
        if (CollectionUtils.isNotEmpty(coll)) {
            throw ValidationException.createValidationException(desc);
        }
    }

    /**
     * 如果为空，就抛出异常
     * @param coll
     */
    public static void throwExceptionIfEmpty(Collection<?> coll) {
        throwExceptionIfEmptyWithDesc(ResultCodeEnums.VALIDATION.getDesc(), coll);
    }

    /**
     * 如果为空，就抛出异常
     * @param desc
     * @param coll
     */
    public static void throwExceptionIfEmptyWithDesc(String desc, Collection<?> coll) {
        if (CollectionUtils.isEmpty(coll)) {
            throw ValidationException.createValidationException(desc);
        }
    }

    /**
     * 字符串如果不相同，就抛出异常
     *
     * @param src
     * @param target
     */
    public static void throwExceptionIfEqualsFalse(String src, String target) {
        throwExceptionIfEqualsFalseWithDesc(ResultCodeEnums.VALIDATION.getDesc(), src, target);
    }

    /**
     * 字符串如果不相同，就抛出异常
     *
     * @param desc
     * @param src
     * @param target
     */
    public static void throwExceptionIfEqualsFalseWithDesc(String desc, String src, String target) {
        throwExceptionIfAnyEqualsFalseWithDesc(desc, src, target);
    }

    /**
     * 字符串如果有任何不相同，就抛出异常
     *
     * @param desc
     * @param src
     * @param target
     */
    public static void throwExceptionIfAnyEqualsFalseWithDesc(String desc, String src, String... target) {
        if (StringUtils.equalsAnyIgnoreCase(src, target)) {
            throw ValidationException.createValidationException(desc);
        }
    }

    /**
     * 字符串如果相同，就抛出异常
     *
     * @param src
     * @param target
     */
    public static void throwExceptionIfEqualsTrue(String src, String target) {
        throwExceptionIfEqualsTrueWithDesc(ResultCodeEnums.VALIDATION.getDesc(), src, target);
    }

    /**
     * 字符串如果相同，就抛出异常
     * @param desc
     * @param src
     * @param target
     */
    public static void throwExceptionIfEqualsTrueWithDesc(String desc, String src, String target) {
        throwExceptionIfAnyEqualsTrueWithDesc(desc, src, target);
    }

    /**
     * 字符串如果有任何相同，就抛出异常
     *
     * @param desc
     * @param src
     * @param target
     */
    public static void throwExceptionIfAnyEqualsTrueWithDesc(String desc, String src, String... target) {
        if (StringUtils.equalsAny(src, target)) {
            throw ValidationException.createValidationException(desc);
        }
    }

    /**
     * 如果有任何一个为空就抛出异常
     * @param v
     */
    public static void throwExceptionIfNotBlank(String v) {
        throwExceptionIfNotBlankWithDesc(ResultCodeEnums.VALIDATION.getDesc(), v);
    }

    /**
     * 如果有任何一个为空就抛出异常
     *
     * @param v
     * @param desc 异常说明
     */
    public static void throwExceptionIfNotBlankWithDesc(String desc, String v) {
        if (StringUtils.isNotBlank(v)) {
            throw ValidationException.createValidationException(desc);
        }
    }

    /**
     * 如果为空就抛出异常
     * @param v
     */
    public static void throwExceptionIfBlank(String v) {
        throwExceptionIfAnyBlank(v);
    }

    /**
     * 如果为空就抛出异常
     *
     * @param v
     * @param desc 异常说明
     */
    public static void throwExceptionIfBlankWithDesc(String desc, String v) {
        throwExceptionIfAnyBlank(desc, v);
    }

    /**
     * 如果有任何一个为空就抛出异常
     * @param v
     */
    public static void throwExceptionIfAnyBlank(String... v) {
        throwExceptionIfAnyBlankWithDesc(ResultCodeEnums.VALIDATION.getDesc(), v);
    }

    /**
     * 如果有任何一个为空就抛出异常
     *
     * @param v
     * @param desc 异常说明
     */
    public static void throwExceptionIfAnyBlankWithDesc(String desc, String... v) {
        if (StringUtils.isAnyBlank(v)) {
            throw ValidationException.createValidationException(desc);
        }
    }
}
