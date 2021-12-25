/**
 * From geek45.com
 * Email to : rubixgeek795@gmail.com
 */
package com.geek45.geekresult.exception;

/**
 * @ClassName: BizException
 * @Decription:
 * @Author: rubik
 * rubik create BizException.java of 2021/12/24 10:25 下午
 */
public class BizException extends RuntimeException {
    /**
     * 错误码
     */
    private String errorCode;

    private BizException() {
        super();
    }

    private BizException(String message) {
        super(message);
    }

    private BizException(Throwable throwable) {
        super(throwable);
    }

    public static BizException createBizException(Throwable throwable) {
        return new BizException(throwable);
    }

    public static BizException createBizException(String errorMsg) {
        return new BizException(errorMsg);
    }

    public static BizException createBizException(String errorCode, String errorMsg) {
        BizException bizException = new BizException(errorMsg);
        bizException.setErrorCode(errorCode);
        return bizException;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

}
