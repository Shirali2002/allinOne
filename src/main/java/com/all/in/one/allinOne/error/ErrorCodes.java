package com.all.in.one.allinOne.error;

import com.all.in.one.allinOne.error.common.ErrorCode;

public enum ErrorCodes implements ErrorCode {

    SERVICE_PROVIDER_ERROR,
    USER_NOT_FOUND;

    @Override
    public String code() {
        return this.name();
    }

}
