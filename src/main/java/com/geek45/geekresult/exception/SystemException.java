/**
 * From geek45.com
 * Email to : rubixgeek795@gmail.com
 */
package com.geek45.geekresult.exception;

/**
 * @ClassName: ValidationException
 * @Decription:
 * @Author: rubik
 * rubik create ValidationException.java of 2021/12/24 10:25 下午
 */
public class SystemException extends RuntimeException {
    /**
     * 错误码
     */
    private String errorCode;

    private SystemException() {
        super();
    }

    private SystemException(String message) {
        super(message);
    }

    private SystemException(Throwable throwable) {
        super(throwable);
    }

    public static SystemException createSystemException(Throwable throwable) {
        return new SystemException(throwable);
    }

    public static SystemException createSystemException(String errorMsg) {
        return new SystemException(errorMsg);
    }

    public static SystemException createSystemException(String errorCode, String errorMsg) {
        SystemException systemException = new SystemException(errorMsg);
        systemException.setErrorCode(errorCode);
        return systemException;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

}
