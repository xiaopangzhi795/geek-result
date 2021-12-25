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
public class ValidationException extends RuntimeException {
    /**
     * 错误码
     */
    private String errorCode;

    private ValidationException() {
        super();
    }

    private ValidationException(String message) {
        super(message);
    }

    private ValidationException(Throwable throwable) {
        super(throwable);
    }

    public static ValidationException createValidationException(Throwable throwable) {
        return new ValidationException(throwable);
    }

    public static ValidationException createValidationException(String errorMsg) {
        return new ValidationException(errorMsg);
    }

    public static ValidationException createValidationException(String errorCode, String errorMsg) {
        ValidationException validationException = new ValidationException(errorMsg);
        validationException.setErrorCode(errorCode);
        return validationException;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

}
