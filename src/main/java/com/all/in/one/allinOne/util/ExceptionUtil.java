package com.all.in.one.allinOne.util;

import org.apache.cxf.transport.http.HTTPException;

import java.net.SocketTimeoutException;
import java.util.Objects;

public final class ExceptionUtil {

    public static boolean isReadTimeoutError(Exception ex) {
        return Objects.nonNull(ex.getCause()) && ex.getCause() instanceof SocketTimeoutException;
    }

    public static boolean isCxfHttpException(Exception ex) {
        return Objects.nonNull(ex.getCause()) && ex.getCause() instanceof HTTPException;
    }

    private ExceptionUtil() {
    }

}
