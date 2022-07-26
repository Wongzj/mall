package com.pet.mall.common.api;

public enum ResultCode implements IErrorCode {
    SUCCESS(200, "success"),
    FAILED(500, "failed"),
    VALIDATE_FAILED(404, "validate fail"),
    UNAUTHORIZED(401, "unauthorized"),
    FORBIDDEN(403, "forbidden");
    private long code;
    private String message;

    private ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    public long getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
