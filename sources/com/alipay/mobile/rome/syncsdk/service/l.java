package com.alipay.mobile.rome.syncsdk.service;

import java.util.concurrent.ThreadFactory;

final class l implements ThreadFactory {
    l() {
    }

    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setName("longlink_timer");
        return thread;
    }
}
