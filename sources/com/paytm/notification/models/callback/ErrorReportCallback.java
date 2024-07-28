package com.paytm.notification.models.callback;

public interface ErrorReportCallback {
    void onError(Throwable th);

    void onErrorLog(String str);

    void onSetUserIdentifier(String str);
}
