package com.paytmmall.clpartifact.navigator;

public interface BaseNavigator<T> {
    void onFailed(Throwable th);

    void onProgress();

    void onSuccess(T t);
}
