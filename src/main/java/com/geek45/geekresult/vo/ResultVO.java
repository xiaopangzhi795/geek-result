/**
 * From geek45.com
 * Email to : rubixgeek795@gmail.com
 */
package com.geek45.geekresult.vo;

import com.geek45.geekresult.exception.BizException;
import com.geek45.geekresult.exception.SystemException;
import com.geek45.geekresult.exception.ValidationException;

import java.io.Serializable;

/**
 * @ClassName: ResultVO
 * @Decription:
 * @Author: rubik
 * rubik create ResultVO.java of 2021/12/24 10:16 下午
 */
public class ResultVO<E> implements Serializable {

    /**
     * code
     */
    private String code;
    /**
     * 是否成功
     */
    private Boolean success;
    /**
     * 说明
     */
    private String desc;
    /**
     * 异常
     */
    private Throwable throwable;
    /**
     * 负载数据
     */
    private E payload;

    private ResultVO() {

    }

    public static <E> ResultVO<E> create() {
        return new ResultVO<>();
    }

    public static <E> ResultVO<E> success() {
        ResultVO<E> result = create();
        result.setSuccess(Boolean.TRUE);
        return result;
    }

    public static <E> ResultVO<E> success(E payload) {
        ResultVO<E> result = success();
        result.setPayload(payload);
        return result;
    }

    public static <E> ResultVO<E> success(String code, String desc) {
        ResultVO<E> result = success();
        result.setCode(code);
        result.setDesc(desc);
        return result;
    }

    public static <E> ResultVO<E> success(E payload, String code, String desc) {
        ResultVO<E> result = success(code, desc);
        result.setPayload(payload);
        return result;
    }

    public static <E> ResultVO<E> fail() {
        ResultVO<E> result = create();
        result.setSuccess(Boolean.FALSE);
        return result;
    }

    public static <E> ResultVO<E> fail(String code, String desc) {
        ResultVO<E> result = fail();
        result.setCode(code);
        result.setDesc(desc);
        return result;
    }

    public static <E> ResultVO<E> error(Throwable throwable) {
        ResultVO<E> result = fail();
        result.setThrowable(throwable);
        return result;
    }

    public static <E> ResultVO<E> error(Throwable throwable, String code, String desc) {
        ResultVO<E> result = fail(code, desc);
        result.setThrowable(throwable);
        return result;
    }

    /**
     * 拿到返回结果
     * @return
     */
    public E unwrap() {
        if (null != throwable) {
            if (throwable instanceof BizException) {
                throw BizException.createBizException(throwable);
            }
            if (throwable instanceof ValidationException) {
                throw ValidationException.createValidationException(throwable);
            }
            throw SystemException.createSystemException(throwable);
        } else {
            return this.payload;
        }
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Boolean isSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

    public E getPayload() {
        return payload;
    }

    public void setPayload(E payload) {
        this.payload = payload;
    }
}
